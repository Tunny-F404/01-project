package com.zeroone.star.project.j1.syshome.dto.production;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 描述：生产进度查询模型
 * @author twelve
 * @version 1.0.0
 */
@Data
@ApiModel("生产进度查询对象")
public class ProductionDTO {
    @ApiModelProperty(value = "订单编号",example = "ZL2050100240")
    private String orderId;
    @ApiModelProperty(value = "客户编号",example = "C1880")
    private String clientId;
    @ApiModelProperty(value = "产品编号",example = "P18480")
    private String productionId;
    @ApiModelProperty(value = "机台",example = "1#注塑机")
    private String facility;
    @ApiModelProperty(value = "生产进度",example = "50%")
    private Integer productionSchedule;
    @ApiModelProperty(value = "交货日期",example = "2024-05-04 18:25")
    private String deliveryDate;
}
