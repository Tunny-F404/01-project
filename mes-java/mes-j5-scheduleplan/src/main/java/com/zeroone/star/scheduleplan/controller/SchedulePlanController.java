package com.zeroone.star.scheduleplan.controller;

import com.zeroone.star.project.dto.PageDTO;
import com.zeroone.star.project.j5.dto.scheduleplan.PlanDTO;
import com.zeroone.star.project.j5.dto.scheduleplan.SchPlanDTO;
import com.zeroone.star.project.j5.query.scheduleplan.PlanPageQuery;
import com.zeroone.star.project.j5.scheduleplan.SchedulePlanApis;
import com.zeroone.star.project.j5.vo.scheduleplan.PlanListVO;
import com.zeroone.star.project.j5.vo.scheduleplan.PlanVO;
import com.zeroone.star.project.vo.JsonVO;
import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 描述：排班计划控制器
 * </p>
 * @author interstellar
 * @version 1.0.0
 */
@RestController
@RequestMapping("sch-manage/sch-plan")
@Api(tags = "班组接口")
public class SchedulePlanController implements SchedulePlanApis {
    @Override
    public JsonVO<PageDTO<PlanListVO>> queryPlanList(PlanPageQuery condition) {
        return null;
    }

    @Override
    public JsonVO<PlanVO> queryPlanDetails(Long planId) {
        return null;
    }

    @Override
    public JsonVO<Integer> addPlan(PlanDTO planDTO) {
        return null;
    }

    @Override
    public JsonVO<Integer> modifyTeam(PlanDTO planDTO) {
        return null;
    }

    @Override
    public JsonVO<Integer> removeSchPlan(Long[] rems) {
        return null;
    }

    @Override
    public JsonVO<Integer> modifySchPlanStatus(SchPlanDTO schPlanDTO) {
        return null;
    }

    @Override
    public ResponseEntity<byte[]> exportSchPlan(PlanPageQuery condition) {
        return null;
    }
}
