package com.zeroone.star.project.j2.sysmanagement.query.menu;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author 熠
 * @version 1.0.0
 * @Description: TODO
 */
public class MenuQuery {

    //资源名称
    @ApiModelProperty(value = "资源名称",example = "部门管理")
    private String title;

    //菜单图标
    @ApiModelProperty(value = "菜单图标",example = "目录")
    private String type;



}
