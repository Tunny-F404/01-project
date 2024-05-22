package com.zeroone.star.scheduleplan.controller.order;

import com.zeroone.star.project.dto.PageDTO;
import com.zeroone.star.project.j5.dto.scheduleplan.shiftplan.ShiftPlanAddDTO;
import com.zeroone.star.project.j5.dto.scheduleplan.shiftplan.ShiftPlanDTO;
import com.zeroone.star.project.j5.dto.scheduleplan.shiftplan.ShiftPlanModifyDTO;
import com.zeroone.star.project.j5.query.scheduleplan.shiftplan.ShiftPlanQuery;
import com.zeroone.star.project.j5.scheduleplan.order.OrderApis;
import com.zeroone.star.project.vo.JsonVO;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 描述：班次控制器
 * </p>
 * @author interstellar
 * @version 1.0.0
 */
@RestController
@RequestMapping("sch-manage/sch-plan/order")
@Api(tags = "班次接口")
public class OrderController implements OrderApis {
    @Override
    public JsonVO<PageDTO<ShiftPlanDTO>> queryShiftPlanByPlanId(ShiftPlanQuery shiftPlanQuery) {
        return null;
    }

    @Override
    public JsonVO<Long> addShiftPlan(ShiftPlanAddDTO shiftPlanAddDto) {
        return null;
    }

    @Override
    public JsonVO<Long> modifyShiftPlan(ShiftPlanModifyDTO shiftPlanModifyDto) {
        return null;
    }

    @Override
    public JsonVO<Long> removeShiftPlan(List<Long> shiftId) {
        return null;
    }
}
