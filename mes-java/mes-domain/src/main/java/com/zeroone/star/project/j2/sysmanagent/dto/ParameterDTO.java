package com.zeroone.star.project.j2.sysmanagent.dto;


import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * 描述：参数设置DTO
 * author: kino
 */
@Data
@ApiOperation("参数设置DTO")
public class ParameterDTO {

    @ApiModelProperty(value = "参数主键", example = "1")
    private Integer config_id;
    @ApiModelProperty(value = "参数名称", example = "验证码开关")
    private String config_name;
    @ApiModelProperty(value = "参数键名", example = "sys.account...")
    private String config_key;
    @ApiModelProperty(value = "参数键值", example = "true")
    private String config_value;
    @ApiModelProperty(value = "系统内置（Y是 N否）", example = "Y")
    private String config_type;
    @ApiModelProperty(value = "创建者", example = "admin")
    private String create_by;
    @ApiModelProperty(value = "创建时间", example = "2022-04-07 00:29:32")
    private Date create_time;
    @ApiModelProperty(value = "更新者", example = "admin")
    private String update_by;
    @ApiModelProperty(value = "更新时间", example = "2022-04-07 00:29:32")
    private Date update_time;
    @ApiModelProperty(value = "备注", example = "XXX")
    private String remark;



}
