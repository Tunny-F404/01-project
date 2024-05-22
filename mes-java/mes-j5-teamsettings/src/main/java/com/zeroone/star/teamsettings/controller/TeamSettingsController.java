package com.zeroone.star.teamsettings.controller;

import com.zeroone.star.project.dto.PageDTO;
import com.zeroone.star.project.j5.dto.teamsettings.TeamDTO;
import com.zeroone.star.project.j5.query.teamsettings.TeamQuery;
import com.zeroone.star.project.j5.teamsettings.TeamSettingsApis;
import com.zeroone.star.project.vo.JsonVO;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;

import java.util.List;

/**
 * <p>
 * 描述：班组设置控制器
 * </p>
 * <p>版权：&copy;01星球</p>
 * <p>地址：01星球总部</p>
 * @author interstellar
 * @version 1.0.0
 */
@RestController
@RequestMapping("sch-manage/team-settings")
@Api(tags = "班组设置接口")
@Validated
public class TeamSettingsController implements TeamSettingsApis {
    @ApiOperation(value = "获取班组列表（条件 + 分页）")
    @GetMapping("query-all")
    @Override
    public JsonVO<PageDTO<TeamDTO>> queryTeamList(TeamQuery condition) {
        return null;
    }

    @Override
    public JsonVO<TeamDTO> queryTeamDetails(Long teamId) {
        return null;
    }

    @Override
    public JsonVO<Integer> addTeam(TeamDTO teamDTO) {
        return null;
    }

    @Override
    public JsonVO<Integer> modifyTeam(TeamDTO teamDTO) {
        return null;
    }

    @Override
    public JsonVO<Integer> removeTeam(List<Long> ids) {
        return null;
    }

    @Override
    public ResponseEntity<byte[]> exportTeam(TeamQuery condition) {
        return null;
    }
}
