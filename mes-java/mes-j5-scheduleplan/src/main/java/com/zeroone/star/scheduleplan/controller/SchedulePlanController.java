package com.zeroone.star.scheduleplan.controller;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zeroone.star.project.dto.PageDTO;
import com.zeroone.star.project.j5.dto.scheduleplan.AddPlanDTO;
import com.zeroone.star.project.j5.dto.scheduleplan.PlanDTO;
import com.zeroone.star.project.j5.query.scheduleplan.PlanPageQuery;
import com.zeroone.star.project.j5.scheduleplan.SchedulePlanApis;
import com.zeroone.star.project.j5.vo.scheduleplan.PlanListVO;
import com.zeroone.star.project.j5.vo.scheduleplan.PlanVO;
import com.zeroone.star.project.vo.JsonVO;
import com.zeroone.star.scheduleplan.service.ICalPlanService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.constraints.Min;
import java.util.List;

/**
 * <p>
 * 描述：排班计划控制器
 * </p>
 *
 * @author interstellar
 * @version 1.0.0
 */
@RestController
@RequestMapping("sch-manage/sch-plan")
@Api(tags = "排班计划接口")
public class SchedulePlanController implements SchedulePlanApis {
    @Resource
    ICalPlanService calPlanService;

    @GetMapping("/query-all")
    @ApiOperation("获取计划列表（条件+分页）")
    public JsonVO<PageDTO<PlanListVO>> queryPlanList(@Validated PlanPageQuery condition) {
        return null;
    }

    @GetMapping("query-by-id")
    @ApiOperation("获取计划详情")
    public JsonVO<PlanVO> queryPlanDetails(@Min(value = 1, message = "planId最小值为1") @RequestParam Long planId) {
        return null;
    }

    @ApiOperation("添加计划")
    @PostMapping("add-plan")
    public JsonVO<Integer> addPlan(AddPlanDTO condition) {
        return null;
    }

    @ApiOperation("修改计划")
    @PutMapping("modify-team")
    public JsonVO<Integer> modifyTeam(PlanDTO planDTO) {
        return null;
    }

    @ApiOperation(value = "删除排班计划(可批量删除)")
    @DeleteMapping("delete-schedule-plan")
    @Override
    public JsonVO<Integer> removeSchPlan(@RequestBody List<Long> rems) {
        return calPlanService.removeSchPlan(rems) ? JsonVO.success(1) : JsonVO.fail(0);
    }


    @ApiOperation(value = "修改计划状态")
    @PutMapping("modify-plans-status")
    @Override
    public JsonVO<Integer> modifySchPlanStatus(PlanDTO planDTO) {
        return calPlanService.modifySchPlanStatus(planDTO) ? JsonVO.success(1) : JsonVO.fail(0);
    }

    @ApiOperation(value = "导出计划")
    @GetMapping("export-schedule-plan")
    @Override
    public ResponseEntity<byte[]> exportSchPlan(List<Long> ids) {
        return calPlanService.exportSchPlan(ids);
    }




}
