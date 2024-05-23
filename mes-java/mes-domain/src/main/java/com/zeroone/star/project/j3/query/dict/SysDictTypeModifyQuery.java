package com.zeroone.star.project.j3.query.dict;

import io.swagger.annotations.ApiModelProperty;

public class SysDictTypeModifyQuery {

    @ApiModelProperty(value = "字典名称", example = "用户性别")
    private String dictName;

    @ApiModelProperty(value = "字典类型", example = "sys_user_sex")
    private String dictType;

    @ApiModelProperty(value = "状态(0正常 1停用)", example = "0")
    private String status;
}
