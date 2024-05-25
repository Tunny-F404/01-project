package com.zeroone.star.scheduleplan.controller.team;

import com.zeroone.star.project.dto.PageDTO;
import com.zeroone.star.project.j5.dto.scheduleplan.planteam.AddPlanTeamDTO;
import com.zeroone.star.project.j5.dto.scheduleplan.planteam.PlanTeamDTO;
import com.zeroone.star.project.j5.query.scheduleplan.planteam.PlanTeamQuery;
import com.zeroone.star.project.j5.scheduleplan.team.TeamApis;
import com.zeroone.star.project.vo.JsonVO;
import com.zeroone.star.project.vo.ResultStatus;
import com.zeroone.star.scheduleplan.service.IPlanTeamService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 * 描述：班组控制器
 * </p>
 * @author linglan
 * @version 1.0.0
 */
@RestController
@RequestMapping("sch-manage/sch-plan/team")
@Api(tags = "班组接口")
public class TeamController implements TeamApis {
        @Resource
        IPlanTeamService planTeamService;
        @GetMapping("/list")
        @ApiOperation("获取关联班组列表(条件+分页)")
        @Override
        public JsonVO<PageDTO<PlanTeamDTO>> queryAllPlanTeam(PlanTeamQuery condition) {
                return null;
        }
        @PostMapping("/add")
        @ApiOperation("添加关联班组(支持多项添加)")
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