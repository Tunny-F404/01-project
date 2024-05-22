package com.zeroone.star.teamsettings.controller.members;

import com.zeroone.star.project.dto.PageDTO;
import com.zeroone.star.project.j5.dto.teamsettings.MemberDTO;
import com.zeroone.star.project.j5.query.teamsettings.MemberQuery;
import com.zeroone.star.project.j5.teamsettings.members.MembersApis;
import com.zeroone.star.project.vo.JsonVO;
import io.swagger.annotations.Api;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    @Override
    public JsonVO<PageDTO<MemberDTO>> queryMember(MemberQuery condition) {
        return null;
    }

    @Override
    public JsonVO<Void> addMembers(List<MemberDTO> memberDTOList) {
        return null;
    }

    @Override
    public JsonVO<Void> deleteMembers(List<Integer> memberIds) {
        return null;
    }

    @Override
    public JsonVO<byte[]> exportMembers(MemberQuery condition) {
        return null;
    }
}
