package com.zeroone.star.project.dto.j4.warehousemanagement.rtsalse;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
@ApiModel("仓储管理销售退货单物料数据传输对象")
public class RtSalseDTO  {
    private static final long serialVersionUID = 1L;

    /** 产品物料ID */
    @ApiModelProperty(value = "产品物料ID")
    private Long itemId;

    @ApiModelProperty(value = "产品物料编码")
    /** 产品物料编码 */
    private String itemCode;

    @ApiModelProperty(value = "产品物料名称")
    /** 产品物料名称 */
    private String itemName;

    @ApiModelProperty(value = "规格型号 ")
    /** 规格型号 */
    private String specification;

    @ApiModelProperty(value = "单位")
    /** 单位 */
    private String unitOfMeasure;

    @ApiModelProperty(value = "入库批次号")
    /** 入库批次号 */
    private String batchCode;

    @ApiModelProperty(value = "仓库ID")
    /** 仓库ID */
    private Long warehouseId;

    @ApiModelProperty(value = "仓库编码")
    /** 仓库编码 */
    private String warehouseCode;

    @ApiModelProperty(value = "仓库名称")
    /** 仓库名称 */
    private String warehouseName;

    @ApiModelProperty(value = "库区ID")
    /** 库区ID */
    private Long locationId;

    @ApiModelProperty(value = "库区编码")
    /** 库区编码 */
    private String locationCode;

    @ApiModelProperty(value = "库区名称")
    /** 库区名称 */
    private String locationName;

    @ApiModelProperty(value = "库位ID ")
    /** 库位ID */
    private Long areaId;

    @ApiModelProperty(value = "库位编码")
    /** 库位编码 */
    private String areaCode;

    @ApiModelProperty(value = "库位名称")
    /** 库位名称 */
    private String areaName;

    @ApiModelProperty(value = "供应商ID")
    /** 供应商ID */
    private Long clientId;

    @ApiModelProperty(value = "客户编号")
    /** 客户编号 */
    private String clientCode;

    @ApiModelProperty(value = "客户名称")
    /** 客户名称 */
    private String clientName;

    @ApiModelProperty(value = "客户简称")
    /** 客户简称 */
    private String clientNick;

    @ApiModelProperty(value = "单据类型")
    /** 单据类型 */
    private String sourceDocType;

    @ApiModelProperty(value = "单据ID")
    /** 单据ID */
    private Long sourceDocId;

    @ApiModelProperty(value = "单据编号")
    /** 单据编号 */
    private String sourceDocCode;

    @ApiModelProperty(value = "单据行ID")
    /** 单据行ID */
    private Long sourceDocLineId;

    @ApiModelProperty(value = "事务数量")
    /** 事务数量 */
    private BigDecimal transactionQuantity;

    @ApiModelProperty(value = "退货日期")
    /** 退货日期 */
    private Date rtDate;
}
