package com.zeroone.star.project.j5.query.shiftplan;

import com.zeroone.star.project.query.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>
 * 描述：班次查询Query（根据排班id查询）
 * </p>
 * <p>版权：&copy;01星球</p>
 * <p>地址：01星球总部</p>
 * @author qwert
 * @version 1.0.0
 */
@Data
@ApiModel("班次计划查询")
public class ShiftPlanQuery extends PageQuery {
    /**
     * 排班计划id
     */
    @ApiModelProperty(value = "排班计划id", example = "1")
    private Long PlanId;
}
