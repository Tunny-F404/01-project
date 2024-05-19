package com.zeroone.star.project.j6.product_management.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>
 * 描述：修改关联供应商
 * </p>
 * <p>版权：&copy;01星球</p>
 * <p>地址：01星球总部</p>
 *
 * @author smile
 * @version 1.0.0
 */
@Data
@ApiModel("修改关联供应商")
public class SupplierDTO {
    @ApiModelProperty(value = "关联供应商id", example = "1")
    private Long id;
    @ApiModelProperty(value = "供应商id", example = "1")
    private Long supplierId;
    @ApiModelProperty(value = "物料id", example = "1")
    private Long productId;
}

