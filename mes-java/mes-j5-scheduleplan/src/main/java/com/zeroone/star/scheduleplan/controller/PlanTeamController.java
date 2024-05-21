package com.zeroone.star.scheduleplan.controller;

import com.zeroone.star.project.dto.PageDTO;
import com.zeroone.star.project.dto.sample.SampleDTO;
import com.zeroone.star.project.j5.dto.planteam.AddPlanTeamDTO;
import com.zeroone.star.project.j5.dto.planteam.PlanTeamDTO;
import com.zeroone.star.project.j5.query.planteam.PlanTeamQuery;
import com.zeroone.star.project.j5.scheduleplan.TeamPlanApis;
import com.zeroone.star.project.query.sample.SampleQuery;
import com.zeroone.star.project.vo.JsonVO;
import com.zeroone.star.project.vo.ResultStatus;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 描述：关联班组控制器
 * </p>
 * @author linglan
 * @version 1.0.0
 */
@RestController
@RequestMapping("/planteam")
@Api(tags = "关联班组")
public class PlanTeamController implements TeamPlanApis {

        @GetMapping("/list")
        @ApiOperation("查询指定条件的关联班组")
        @Override
        public JsonVO<PageDTO<PlanTeamDTO>> queryAllPlanTeam(PlanTeamQuery condition) {
                return null;
        }
        @GetMapping("/add")
        @ApiOperation("添加关联班组")
        @Override
        public JsonVO<ResultStatus> addPlanTeam(AddPlanTeamDTO addPlanTeamDTO) {
                return null;
        }

        @GetMapping("/delete")
        @ApiOperation("删除关联班组")
        @Override
        public JsonVO<ResultStatus> deletePlanTeam(Long id) {
                return null;
        }
}