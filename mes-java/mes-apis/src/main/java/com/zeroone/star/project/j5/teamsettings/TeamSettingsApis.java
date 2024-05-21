package com.zeroone.star.project.j5.teamsettings;

import com.zeroone.star.project.dto.PageDTO;
import com.zeroone.star.project.dto.sample.SampleDTO;
import com.zeroone.star.project.j5.teamsettings.dto.TeamMemberDTO;
import com.zeroone.star.project.j5.teamsettings.query.TeamMemberQuery;
import com.zeroone.star.project.query.sample.SampleQuery;
import com.zeroone.star.project.vo.JsonVO;

import java.util.List;

/**
 * <p>
 * 描述：班组设置接口
 * </p>
 * <p>版权：&copy;01星球</p>
 * <p>地址：01星球总部</p>
 * @author interstellar
 * @version 1.0.0
 */
public interface TeamSettingsApis {
    /**
     * 班组的分页查询
     * @param condition 查询条件
     * @return 查询结果
     */
    JsonVO<PageDTO<TeamMemberDTO>> queryTeamMember(TeamMemberQuery condition);

    /**
     * 通过编号查询数据
     * @param teamCode 班组编码
     * @param teamName 班组名称
     * @param calendarType 班组类型
     * @return 查询结果
     */
    JsonVO<TeamMemberDTO> queryTeamByCondition(String teamCode, String teamName, String calendarType);
    /**
     * 多项添加班组成员
     * @param teamMemberDTOList 要添加的成员list表
     * @return 添加班组成员
     */
    JsonVO<Void> addMembers(List<TeamMemberDTO> teamMemberDTOList);
    /**
     * 批量删除班组成员
     * @param memberIds 成员ID列表
     * @return 删除结果
     */
    JsonVO<Void> deleteMembers(List<Integer> memberIds);
    /**
     * 导出班组成员信息
     * @param condition 查询条件
     * @return 导出的班组成员信息文件
     */
    JsonVO<byte[]> exportMembers(TeamMemberQuery condition);
}
