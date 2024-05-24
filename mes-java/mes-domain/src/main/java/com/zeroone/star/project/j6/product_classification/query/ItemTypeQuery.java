package com.zeroone.star.project.j6.product_classification.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "ItemTypeQuery", description = "物料产品分类查询条件")
public class ItemTypeQuery {
    @ApiModelProperty(value = "分类ID")
    private Long itemTypeId;

    @ApiModelProperty(value = "父分类ID")
    private Long parentTypeId;

    @ApiModelProperty(value = "分类编码")
    private String itemTypeCode;

    @ApiModelProperty(value = "分类名称")
    private String itemTypeName;

    @ApiModelProperty(value = "启用标识")
    private String enableFlag;

    @ApiModelProperty(value = "产品物料标识")
    private String itemOrProduct;

    @ApiModelProperty(value = "当前页码", example = "1")
    private Integer page;

    @ApiModelProperty(value = "每页大小", example = "10")
    private Integer size;
}
