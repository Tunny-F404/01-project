package com.zeroone.star.scheduleplan.service;

import com.zeroone.star.project.dto.PageDTO;
import com.zeroone.star.project.j5.dto.scheduleplan.shiftplan.ShiftPlanAddDTO;
import com.zeroone.star.project.j5.dto.scheduleplan.shiftplan.ShiftPlanDTO;
import com.zeroone.star.project.j5.dto.scheduleplan.shiftplan.ShiftPlanModifyDTO;
import com.zeroone.star.project.j5.query.scheduleplan.shiftplan.ShiftPlanQuery;
import com.zeroone.star.project.vo.ResultStatus;
import com.zeroone.star.scheduleplan.entity.CalShift;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 计划班次表 服务类
 * </p>
 *
 * @author interstellar
 * @since 2024-05-25
 */
public interface ICalShiftService extends IService<CalShift> {

    ResultStatus addShiftPlan(ShiftPlanAddDTO shiftPlanAddDto);

    ResultStatus modifyShiftPlan(ShiftPlanModifyDTO shiftPlanModifyDto);

    PageDTO<ShiftPlanDTO> queryShiftPlanByPlanId(ShiftPlanQuery shiftPlanQuery);
}
