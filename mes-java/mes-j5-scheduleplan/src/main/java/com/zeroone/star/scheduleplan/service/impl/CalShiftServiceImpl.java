package com.zeroone.star.scheduleplan.service.impl;

import com.zeroone.star.project.j5.dto.scheduleplan.shiftplan.ShiftPlanAddDTO;
import com.zeroone.star.project.j5.dto.scheduleplan.shiftplan.ShiftPlanModifyDTO;
import com.zeroone.star.project.vo.ResultStatus;
import com.zeroone.star.scheduleplan.entity.CalShift;
import com.zeroone.star.scheduleplan.mapper.CalShiftMapper;
import com.zeroone.star.scheduleplan.service.ICalShiftService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 计划班次表 服务实现类
 * </p>
 *
 * @author interstellar
 * @since 2024-05-25
 */
@Service
public class CalShiftServiceImpl extends ServiceImpl<CalShiftMapper, CalShift> implements ICalShiftService {

    @Override
    public Long addShiftPlan(ShiftPlanAddDTO shiftPlanAddDto) {
        //获取当前planId（计划id）
        Long planId = 1L;
        //查找数据库当前planId

        //判断新添加的序号是否存在

        //查询当前planId下shift班次是否达到上限（两班倒上线为两个，三班倒为三个）

        //序号不存在，且没有达到上限，新添加数据

        //返回新增的班次id
        return null;
    }

    @Override
    public ResultStatus modifyShiftPlan(ShiftPlanModifyDTO shiftPlanModifyDto) {
        //查询shiftId（排班id）

        //修改数据
        return null;
    }
}
