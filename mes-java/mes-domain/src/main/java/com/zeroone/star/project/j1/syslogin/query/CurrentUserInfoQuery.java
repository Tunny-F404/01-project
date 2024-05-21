package com.zeroone.star.project.j1.syslogin.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("当前用户信息查询")
public class CurrentUserInfoQuery {
	@ApiModelProperty(value = "用户ID", required = true)
	Integer user_id;
}
