package com.zeroone.star.project.j5.teamsettings.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author: Liang
 * @Date: 2024/05/21/19:00
 * @Description:
 */
@Data
@ApiModel("java传输数据对象")
public class TeamMemberDTO {
    @ApiModelProperty(value = "编号", example = "1")
    private String searchValue;
    private String createBy;
    private String createTime;
    private String updateBy;
    private String updateTime;
    private String remark;
    private Integer teamId;
    private String teamCode;
    private String teamName;
    private String calendarType;
    private String attr1;
    private String attr2;
    private Integer attr3;
    private Integer attr4;
}
