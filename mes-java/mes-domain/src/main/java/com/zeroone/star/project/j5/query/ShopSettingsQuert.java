package com.zeroone.star.project.j5.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@ApiModel("车间管理查询对象")
public class ShopSettingsQuert {
    @ApiModelProperty(value = "车间编码", example = "WS001")
    private String workshop_code;
    @ApiModelProperty(value = "车间名称", example = "五金车间")
    private String workshop_name;
}
