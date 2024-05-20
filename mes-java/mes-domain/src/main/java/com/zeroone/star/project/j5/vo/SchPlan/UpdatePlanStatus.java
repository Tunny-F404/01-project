package com.zeroone.star.project.j5.vo.SchPlan;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("排班计划显示层对象--修改计划状态")
public class UpdatePlanStatus {
    @ApiModelProperty(value = "计划id")
    private int planId;
    @ApiModelProperty(value = "计划编号")
    private String planCode;
    @ApiModelProperty(value = "计划状态")
    private String status;
}
