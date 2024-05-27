package com.zeroone.star.scheduleplan.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zeroone.star.project.dto.PageDTO;
import com.zeroone.star.project.j5.dto.scheduleplan.shiftplan.ShiftPlanAddDTO;
import com.zeroone.star.project.j5.dto.scheduleplan.shiftplan.ShiftPlanDTO;
import com.zeroone.star.project.j5.dto.scheduleplan.shiftplan.ShiftPlanModifyDTO;
import com.zeroone.star.project.j5.query.scheduleplan.shiftplan.ShiftPlanQuery;
import com.zeroone.star.project.vo.ResultStatus;
import com.zeroone.star.scheduleplan.entity.CalShift;
import com.zeroone.star.scheduleplan.mapper.CalShiftMapper;
import com.zeroone.star.scheduleplan.service.ICalShiftService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 计划班次表 服务实现类
 * </p>
 *
 * @author interstellar
 * @since 2024-05-25
 */

@Mapper(componentModel = "spring")
interface msCalShiftPlanMapper{
    /**
     * 添加班次DTO转实体类
     * @param shiftPlanAddDTO 添加班次DTO
     * @return  班次实体类
     */
    CalShift addShiftPlanToShiftPlan(ShiftPlanAddDTO shiftPlanAddDTO);

    /**
     * 修改班次DTO转实体类
     * @param shiftPlanModifyDTO 修改班次DTO
     * @return  班次实体类
     */
    CalShift modifyShiftPlanToShiftPlan(ShiftPlanModifyDTO shiftPlanModifyDTO);

    /**
     * 班次实体类转DTO
     * @param shiftPlan 班次实体类
     * @return  ShiftPlanDTO班次DTO
     */
    ShiftPlanDTO shiftPlanToShiftPlanDTO(CalShift shiftPlan);
}

@Service
public class CalShiftServiceImpl extends ServiceImpl<CalShiftMapper, CalShift> implements ICalShiftService {

    @Resource
    msCalShiftPlanMapper msCalShiftPlanMapper;
    @Override
    public ResultStatus addShiftPlan(ShiftPlanAddDTO shiftPlanAddDto) {
        //获取当前planId（计划id） ShiftPlanAddDTO(planId=1, orderNum=2, shiftName=白班, startTime=8:00, endTime=16:00)
//        Long planId = shiftPlanAddDto.getPlanId();
        //查找数据库当前planId
        CalShift existingCalShift = baseMapper.selectById(shiftPlanAddDto.getPlanId());
        System.out.println(existingCalShift);

        //判断新添加的序号是否存在
        if(existingCalShift != null){
            return ResultStatus.FAIL;
        }

        //shiftType=SINGLE && count>0 返回错误提示：轮班方式为 白班 时只能有一个班次！

        //shiftType=SHIFT_TWO && count>1 返回错误提示：轮班方式为 两班倒 时只能有两个班次！

        //shiftType=SHIFT_THREE && count>2 返回错误提示：轮班方式为 三班倒 时只能有三个班次！


        //序号不存在，且没有达到上限，新添加数据
        CalShift calShift = msCalShiftPlanMapper.addShiftPlanToShiftPlan(shiftPlanAddDto);
        int row = baseMapper.insert(calShift);
        //返回新增的班次id
        if(row > 0) {
            return ResultStatus.SUCCESS;
        }
        return ResultStatus.FAIL;
    }

    @Override
    public ResultStatus modifyShiftPlan(ShiftPlanModifyDTO shiftPlanModifyDto) {
        //查询shiftId（排班id）

        //修改数据
        return null;
    }

    @Override
    public PageDTO<ShiftPlanDTO> queryShiftPlanByPlanId(ShiftPlanQuery shiftPlanQuery) {
        Page<CalShift> page = new Page<>(shiftPlanQuery.getPageIndex(), shiftPlanQuery.getPageSize());
        QueryWrapper<CalShift> wrapper = new QueryWrapper<>();
        wrapper.eq("plan_id", shiftPlanQuery.getPlanId());
        Page<CalShift> result = baseMapper.selectPage(page, wrapper);
        System.out.println(result);
        return PageDTO.create(result, msCalShiftPlanMapper::shiftPlanToShiftPlanDTO);
    }
}
