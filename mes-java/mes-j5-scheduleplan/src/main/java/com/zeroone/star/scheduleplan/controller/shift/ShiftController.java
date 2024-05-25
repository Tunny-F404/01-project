package com.zeroone.star.scheduleplan.controller.shift;

import com.zeroone.star.project.dto.PageDTO;
import com.zeroone.star.project.j5.dto.scheduleplan.shiftplan.ShiftPlanAddDTO;
import com.zeroone.star.project.j5.dto.scheduleplan.shiftplan.ShiftPlanDTO;
import com.zeroone.star.project.j5.dto.scheduleplan.shiftplan.ShiftPlanModifyDTO;
import com.zeroone.star.project.j5.query.scheduleplan.shiftplan.ShiftPlanQuery;
import com.zeroone.star.project.j5.scheduleplan.shift.ShiftApis;
import com.zeroone.star.project.vo.JsonVO;
import com.zeroone.star.scheduleplan.service.ICalShiftService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
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
public class ShiftController implements ShiftApis {
    @Resource
    ICalShiftService calShiftService;
    @GetMapping("/list")
    @ApiOperation("获取班次列表（条件+分页）")
    @Override
    public JsonVO<PageDTO<ShiftPlanDTO>> queryShiftPlanByPlanId(ShiftPlanQuery shiftPlanQuery) {
        return null;
    }

    @PostMapping("/add")
    @ApiOperation("添加班次")
    @Override
    public JsonVO<Long> addShiftPlan(ShiftPlanAddDTO shiftPlanAddDto) {
        return null;
    }

    @PutMapping("/modify")
    @ApiOperation("修改班次")
    @Override
    public JsonVO<Long> modifyShiftPlan(ShiftPlanModifyDTO shiftPlanModifyDto) {
        return null;
    }

    @DeleteMapping("/remove")
    @ApiOperation("删除班次（支持批量删除）")
    @Override
    public JsonVO<Long> removeShiftPlan(List<Long> shiftId) {
        return null;
    }
}
