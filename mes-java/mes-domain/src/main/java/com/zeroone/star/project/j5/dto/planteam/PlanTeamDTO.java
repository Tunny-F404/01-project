package com.zeroone.star.project.j5.dto.planteam;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * <p>
 * 描述：关联班组模型
 * </p>
 *
 * @author linglan
 * @version 1.0.0
 */
@Data
@ApiModel("关联班组模型")
public class PlanTeamDTO {
    @ApiModelProperty(value = "搜索值", example = "null")
    private String searchValue;
    @ApiModelProperty(value = "创建者", example = "")
    private String createBy;
    @ApiModelProperty(value = "创建时间", example = "2024-05-17 17:41:50")
    private String createTime;
    @ApiModelProperty(value = "更新者", example = "")
    private String updateBy;
    @ApiModelProperty(value = "更新时间", example = "2024-05-17 17:41:50")
    private String updateTime;
    @ApiModelProperty(value = "备注", example = "")
    private String remark;
    @ApiModelProperty(value = "参数", example = "{}")
    private List<String> params;
    @ApiModelProperty(value = "流水号", example = "1")
    private Long recordId;
    @ApiModelProperty(value = "计划ID", example = "0")
    private Long planId;
    @ApiModelProperty(value = "班组ID", example = "1")
    private Long teamId;
    @ApiModelProperty(value = "班组编号", example = "T004")
    private String teamCode;
    @ApiModelProperty(value = "班组名称", example = "风塔2组")
    private String teamName;
    @ApiModelProperty(value = "预留字段1", example = "null")
    private String attr1;
    @ApiModelProperty(value = "预留字段2", example = "null")
    private String attr2;
    @ApiModelProperty(value = "预留字段3", example = "null")
    private String attr3;
    @ApiModelProperty(value = "预留字段4", example = "null")
    private String attr4;
}

