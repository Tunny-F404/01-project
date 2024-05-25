package com.zeroone.star.project.j6.product_management.query;

import com.zeroone.star.project.query.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 描述：产品SOP查询对象
 * </p>
 * @version 1.0.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel("产品SOP查询对象")
public class ProductSopQuery extends PageQuery {
    @ApiModelProperty(value = "排列顺序", example = "1")
    private Integer orderNum;

    @ApiModelProperty(value = "工序编号", example = "PROC-001")
    private String processCode;

    @ApiModelProperty(value = "标题", example = "装配SOP")
    private String sopTitle;
}
