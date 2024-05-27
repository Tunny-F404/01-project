package com.zeroone.star.scheduleplan.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zeroone.star.project.dto.PageDTO;
import com.zeroone.star.project.j5.dto.scheduleplan.shiftplan.ShiftPlanAddDTO;
import com.zeroone.star.project.j5.dto.scheduleplan.shiftplan.ShiftPlanDTO;
import com.zeroone.star.project.j5.dto.scheduleplan.shiftplan.ShiftPlanModifyDTO;
import com.zeroone.star.project.j5.query.scheduleplan.shiftplan.ShiftPlanQuery;
import com.zeroone.star.project.vo.ResultStatus;
import com.zeroone.star.scheduleplan.entity.CalPlan;
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
    public int addShiftPlan(ShiftPlanAddDTO shiftPlanAddDto) {
        //查找数据库当前planId
        //CalPlan existingCalPlan = baseMapper.selectById(shiftPlanAddDto.getPlanId());
        //System.out.println(existingCalPlan);

        //1、判断新添加的序号是否存在
        //if(existingCalPlan != null){
        //    return ResultStatus.FAIL;
        //}

        //shiftType=SINGLE && count>0 返回错误提示：轮班方式为 白班 时只能有一个班次！

        //shiftType=SHIFT_TWO && count>1 返回错误提示：轮班方式为 两班倒 时只能有两个班次！

        //shiftType=SHIFT_THREE && count>2 返回错误提示：轮班方式为 三班倒 时只能有三个班次！

        //2、判断是否重复
        System.out.println(baseMapper.selectList(new QueryWrapper<CalShift>().eq("plan_id", shiftPlanAddDto.getPlanId())));
        //序号不存在，且没有达到上限，新添加数据
//        CalShift calShift = msCalShiftPlanMapper.addShiftPlanToShiftPlan(shiftPlanAddDto);
//        //返回修改的行数
//        return baseMapper.insert(calShift);
        return 0;

    }

    @Override
    public int modifyShiftPlan(ShiftPlanModifyDTO shiftPlanModifyDto) {
        //查询shiftId（班次id）
//        CalShift existingCalShift = baseMapper.selectById(shiftPlanModifyDto.getShiftId());
//        System.out.println("existingCalShift"+existingCalShift);

        //修改数据
        CalShift calShift = msCalShiftPlanMapper.modifyShiftPlanToShiftPlan(shiftPlanModifyDto);
//        System.out.println("calShift"+calShift);
//
//        return baseMapper.updateById(calShift);
        UpdateWrapper<CalShift> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("shift_id", calShift.getShiftId())
                .eq("plan_id", calShift.getPlanId())
                .set("order_num", calShift.getOrderNum())
                .set("shift_name", calShift.getShiftName())
                .set("start_time", calShift.getStartTime())
                .set("end_time", calShift.getEndTime());
        return baseMapper.update(calShift, updateWrapper);
    }

    @Override
    public PageDTO<ShiftPlanDTO> queryShiftPlanByPlanId(ShiftPlanQuery shiftPlanQuery) {
        Page<CalShift> page = new Page<>(shiftPlanQuery.getPageIndex(), shiftPlanQuery.getPageSize());
        QueryWrapper<CalShift> wrapper = new QueryWrapper<>();
        wrapper.eq("plan_id", shiftPlanQuery.getPlanId());
        Page<CalShift> result = baseMapper.selectPage(page, wrapper);

        return PageDTO.create(result, msCalShiftPlanMapper::shiftPlanToShiftPlanDTO);
    }
}
