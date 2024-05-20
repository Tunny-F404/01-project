package com.zeroone.star.project.j1.orgstructure.query.user;
import com.zeroone.star.project.j1.orgstructure.query.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel("分配角色查询对象")
public class UserQuery extends PageQuery {
/**
 * 用户名称
 */
@ApiModelProperty(value = "用户名称",example = "1")
private String userName;
/**
 *角色ID
 */
@ApiModelProperty(value = "角色编号",example = "1")
private Long roleId;
}
