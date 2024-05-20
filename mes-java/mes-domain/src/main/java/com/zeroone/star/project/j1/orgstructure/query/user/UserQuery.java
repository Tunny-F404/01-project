package com.zeroone.star.project.j1.orgstructure.query.user;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel("分配角色查询对象")
public class UserQuery {
/**
 * 用户名称
 */
@ApiModelProperty(value = "用户名称",example = "1")
private String userName;
/**
 * 状态
 */
@ApiModelProperty(value = "帐号状态（0正常 1停用）",example = "0")
private int status;
}
