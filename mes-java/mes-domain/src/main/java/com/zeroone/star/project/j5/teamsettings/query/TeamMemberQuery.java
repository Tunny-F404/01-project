package com.zeroone.star.project.j5.teamsettings.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Author: Liang
 * @Date: 2024/05/21/19:06
 * @Description:
 */
@Data
@ApiModel("示例查询对象")
public class TeamMemberQuery {
    @ApiModelProperty(value = "班组编号", example = "3")
    private String teamCode;
    @ApiModelProperty(value = "班组名称", example = "班组33")
    private String teamName;
    @ApiModelProperty(value = "班组类型", example = "CNC")
    private String calendarType;
}
