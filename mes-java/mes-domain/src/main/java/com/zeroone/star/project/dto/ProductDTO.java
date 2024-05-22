package com.zeroone.star.project.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("添加/修改产品传输对象")
public class ProductDTO {

    @ApiModelProperty(value = "产品ID", example = "1")
    private Long clientId;
    @ApiModelProperty(value = "物料编码", example = "1")
    private String productCode;
    @ApiModelProperty(value = "物料名称", example = "1")
    private String productName;
    @ApiModelProperty(value = "规格型号", example = "1")
    private String specification;
    @ApiModelProperty(value = "单位", example = "1")
    private String unitOfMeasure;
    @ApiModelProperty(value = "产品分类", example = "1")
    private String classification;
    @ApiModelProperty(value = "是否启用", example = "1")
    private String enableFlag;
    @ApiModelProperty(value = "安全库存", example = "1")
    private String safeFlag;
    @ApiModelProperty(value = "备注", example = "1")
    private String remark;
}
