package com.zeroone.star.project.j1.syslogin.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("当前用户菜单查询")
public class CurrentUserMenuQuery {
	@ApiModelProperty(value = "用户ID", required = true)
	Integer user_id;
}
