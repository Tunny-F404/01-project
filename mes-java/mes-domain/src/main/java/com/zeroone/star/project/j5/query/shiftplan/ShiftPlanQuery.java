package com.zeroone.star.project.j5.query.shiftplan;

import com.zeroone.star.project.query.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@Data
@ApiModel("班次计划查询")
public class ShiftPlanQuery extends PageQuery {
    /**
     * 排班计划id
     */
    @ApiModelProperty(value = "排班计划id", example = "1")
    private Integer PlanId;
}
