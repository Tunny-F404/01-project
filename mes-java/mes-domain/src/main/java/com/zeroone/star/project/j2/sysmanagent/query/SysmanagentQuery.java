package com.zeroone.star.project.j2.sysmanagent.query;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;

/**
 * @author 熠
 * @version 1.0.0
 * @Description: TODO
 */
public class SysmanagentQuery {

    //资源名称
    @ApiModelProperty(value = "资源名称",example = "部门管理")
    private String title;

    //菜单图标
    @ApiModelProperty(value = "菜单图标",example = "目录")
    private String type;



}
