package com.zeroone.star.project.j6.customer.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author 小鱼
 * @Description 客户查询对象
 * @Date 12:38 2024/5/20
 **/

@Data
@ApiModel("客户查询对象")
public class ClientQuery {
    /**
     * 客户ID
     */
    @ApiModelProperty(value = "客户ID", example = "1")
    private Long clientId;

    /**
     * 客户编码
     */
    @ApiModelProperty(value = "客户编码", example = "001")
    private String clientCode;

    /**
     * 客户名称
     */
    @ApiModelProperty(value = "客户名称", example = "客户1")
    private String clientName;

    /**
     * 客户英文名称
     */
    @ApiModelProperty(value = "客户英文名称", example = "Client1")
    private String clientEn;

    /**
     * 是否启用
     */
    @ApiModelProperty(value = "是否启用", example = "是")
    private String enableFlag;


}
