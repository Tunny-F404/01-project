package com.zeroone.star.project.j5.teamsettings;

import com.zeroone.star.project.dto.PageDTO;
import com.zeroone.star.project.j5.dto.teamsettings.TeamListDTO;
import com.zeroone.star.project.j5.query.teamsettings.TeamQuery;
import com.zeroone.star.project.vo.JsonVO;

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
     * 查询班组列表
     * @author interstellar
     * @param condition 查询条件
     * @return 班组列表
     */
    JsonVO<PageDTO<TeamListDTO>> queryTeamList(TeamQuery condition);
}
