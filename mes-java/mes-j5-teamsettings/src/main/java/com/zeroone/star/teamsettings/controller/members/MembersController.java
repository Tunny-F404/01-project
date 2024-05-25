package com.zeroone.star.teamsettings.controller.members;

import com.zeroone.star.project.dto.PageDTO;
import com.zeroone.star.project.j5.dto.teamsettings.MemberDTO;
import com.zeroone.star.project.j5.query.teamsettings.MemberQuery;
import com.zeroone.star.project.j5.teamsettings.members.MembersApis;
import com.zeroone.star.project.vo.JsonVO;
import com.zeroone.star.teamsettings.service.ICalTeamMemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 描述：项目组成员控制器
 * </p>
 * <p>版权：&copy;01星球</p>
 * <p>地址：01星球总部</p>
 * @author interstellar
 * @version 1.0.0
 */
@RestController
@RequestMapping("sch-manage/team-settings/members")
@Api(tags = "项目组成员接口")
@Validated
public class MembersController implements MembersApis {
    @Resource
    ICalTeamMemberService calTeamMemberService;
    @ApiOperation(value = "获取班组成员列表（条件 + 分页）")
    @GetMapping("query-all")
    @Override
    public JsonVO<PageDTO<MemberDTO>> queryMember(MemberQuery condition) {
        return null;
    }
    @ApiOperation(value = "添加班组成员")
    @PostMapping("add-member")
    @Override
    public JsonVO<Void> addMembers(List<MemberDTO> memberDTOList) {
        return null;
    }
    @ApiOperation(value = "删除班组成员")
    @PostMapping("delete-member")
    @Override
    public JsonVO<Void> deleteMembers(List<Integer> memberIds) {
        return null;
    }
    @ApiOperation(value = "导出班组成员")
    @GetMapping("export-member")
    @Override
    public JsonVO<byte[]> exportMembers(MemberQuery condition) {
        return null;
    }
}
