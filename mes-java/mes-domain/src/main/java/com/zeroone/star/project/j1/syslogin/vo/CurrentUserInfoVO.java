package com.zeroone.star.project.j1.syslogin.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("当前用户信息")
public class CurrentUserInfoVO {
	@ApiModelProperty(value = "头像地址")
	private String avatar;
	@ApiModelProperty(value = "用户名称")
	private String user_name;
	@ApiModelProperty(value = "手机号码")
	private String phonenumber;
	@ApiModelProperty(value = "邮箱")
	private String email;
	@ApiModelProperty(value = "所属部门")
	private String dept_name;
	@ApiModelProperty(value = "所属角色")
	private String role_name[];
	@ApiModelProperty(value = "创建时间")
	private String create_time;
	@ApiModelProperty(value = "岗位名称")
	private String post_name;
}
