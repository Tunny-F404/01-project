package com.zeroone.star.project.j2.sysmanagent.dto;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.Data;

/**
 * @author 熠
 * @version 1.0.0
 * @Description: TODO
 */

@Data
@ApiOperation("系统管理数据对象")
public class SysmanagentDTO {

    //资源名称
    @ApiModelProperty(value = "资源名称",example = "部门管理")
    private String title;

    //菜单类型
    @ApiModelProperty(value = "菜单类型",example = "目录")
    private String type;

    //菜单图标
    @ApiModelProperty(value = "菜单图标",example = "el-icon-menu")
    private String icon;

    //菜单名称
    @ApiModelProperty(value = "菜单名称",example = "部门管理")
    private String name;

    //排序
    @ApiModelProperty(value = "排序",example = "1")
    private Integer sort;

    //外链判断
    @ApiModelProperty(value = "外链判断",example = "0")
    private Integer isFrame;

    //路由地址
    @ApiModelProperty(value = "路由地址",example = "ip")
    private String path;

    //显示状态
    @ApiModelProperty(value = "显示状态",example = "0")
    private Integer visible;

    //菜单状态
    @ApiModelProperty(value = "菜单状态",example = "0")
    private Integer status;
}
