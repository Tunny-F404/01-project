package com.zeroone.star.project.j5.dto.scheduleplan.planteam;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

/**
 * <p>
 * 描述：关联班组模型
 * </p>
 *
 * @author linglan
 * @version 1.0.0
 */
@Data
@ApiModel("添加关联班组模型")
public class AddPlanTeamDTO {
    @NotBlank(message = "班组编号不能为空")
    @Min(value = 1, message = "班组ID不能小于1")
    @ApiModelProperty(value = "班组ID", example = "1")
    private Long teamId;
    @NotBlank(message = "班组编号不能为空")
    @ApiModelProperty(value = "班组编号", example = "T004")
    private String teamCode;
    @NotBlank(message = "班组名称不能为空")
    @ApiModelProperty(value = "班组名称", example = "风塔2组")
    private String teamName;
    @NotBlank(message = "计划ID不能为空")
    @Min(value = 1, message = "计划ID不能小于1")
    @ApiModelProperty(value = "计划ID", example = "0")
    private Long planId;
}