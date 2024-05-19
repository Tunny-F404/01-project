package com.zeroone.star.project.j6.product_management.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>
 * 描述：关联供应商显示对象
 * </p>
 * <p>版权：&copy;01星球</p>
 * <p>地址：01星球总部</p>
 *
 * @author smile
 * @version 1.0.0
 */

@ApiModel("关联供应商显示对象")
@Data
public class SupplierVO {
    @ApiModelProperty(value = "关联供应商唯一编号", example = "1")
    private Long id;
    @ApiModelProperty(value = "供应商id", example = "1")
    private Long supplierId;
    @ApiModelProperty(value = "物料id", example = "1")
    private Long productId;
}
