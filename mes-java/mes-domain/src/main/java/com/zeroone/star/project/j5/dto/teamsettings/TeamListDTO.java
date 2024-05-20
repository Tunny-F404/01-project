package com.zeroone.star.project.j5.dto.teamsettings;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>
 * 描述：查询然后响应的的班组列表
 * </p>
 * <p>版权：&copy;01星球</p>
 * <p>地址：01星球总部</p>
 * @author interstellar
 * @version 1.0.0
 */
@Data
@ApiModel("班组列表传输对象")
public class TeamListDTO {
    @ApiModelProperty(value = "班组ID", example = "T004")
    private Long teamId;
    @ApiModelProperty(value = "班组编号", example = "TX001")
    private String teamCode;
    @ApiModelProperty(value = "班组名称", example = "风塔2组")
    private String teamName;
    @ApiModelProperty(value = "班组类型", example = "机加工")
    private String calendarType;
}
