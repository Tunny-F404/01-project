package com.zeroone.star.scheduleplan.controller;

import com.zeroone.star.project.dto.PageDTO;
import com.zeroone.star.project.j5.dto.scheduleplan.planteam.AddPlanTeamDTO;
import com.zeroone.star.project.j5.dto.scheduleplan.planteam.PlanTeamDTO;
import com.zeroone.star.project.j5.query.scheduleplan.planteam.PlanTeamQuery;
import com.zeroone.star.project.j5.scheduleplan.team.TeamApis;
import com.zeroone.star.project.vo.JsonVO;
import com.zeroone.star.project.vo.ResultStatus;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

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
public class PlanTeamController implements TeamApis {

        @GetMapping("/list")
        @ApiOperation("查询指定条件的关联班组")
        @Override
        public JsonVO<PageDTO<PlanTeamDTO>> queryAllPlanTeam(PlanTeamQuery condition) {
                return null;
        }
        @PostMapping("/add")
        @ApiOperation("添加关联班组")
        @Override
        public JsonVO<ResultStatus> addPlanTeam(AddPlanTeamDTO addPlanTeamDTO) {
                return null;
        }

        @DeleteMapping("/delete")
        @ApiOperation("删除关联班组")
        @Override
        public JsonVO<ResultStatus> deletePlanTeam(Integer recordId) {
                return null;
        }
}