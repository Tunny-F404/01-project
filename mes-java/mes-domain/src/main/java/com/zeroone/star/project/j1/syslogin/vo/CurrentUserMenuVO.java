package com.zeroone.star.project.j1.syslogin.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("当前用户菜单")
public class CurrentUserMenuVO {
	// TODO: 2023/5/21 菜单信息,字段，待改进

	@ApiModelProperty(value = "菜单名称")
	String menu_name;
	@ApiModelProperty(value = "图标")
	String icon;
	@ApiModelProperty(value = "排序")
	Integer order_Num;
	@ApiModelProperty(value = "权限标识")
	String perms;
	@ApiModelProperty(value = "组件路径")
	String component;
	@ApiModelProperty(value = "菜单状态(0正常，1停用)")
	Integer status;
	@ApiModelProperty(value = "创建时间")
	String create_time;
}
