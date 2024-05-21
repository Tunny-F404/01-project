package com.zeroone.star.project.j5.teamsettings.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author: Liang
 * @Date: 2024/05/21/19:06
 * @Description:班组成员的查询
 */
@Data
@ApiModel("查询人员")
public class MemberQuery {
    @ApiModelProperty(value = "部门名称id", example = "182")
    private String deptId;
    @ApiModelProperty(value = "手机号码", example = "213231")
    private String phonenumber;
    @ApiModelProperty(value = "用户名称", example = "苏念")
    private String username;
}
