package com.zeroone.star.project.j5.dto.teamsettings;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author: Liang
 * @Date: 2024/05/21/19:00
 * @Description:班组成员的dto
 */
@Data
@ApiModel("传输数据对象 组员member的数据")
public class MemberDTO {
    @ApiModelProperty(value = "参数", example = "1")
    private Object params;
    @ApiModelProperty(value = "用户编号", example = "1")
    private Integer userId;
    @ApiModelProperty(value = "部门编号", example = "1")
    private Integer deptId;
    @ApiModelProperty(value = "用户名称", example = "1")
    private String userName;
    @ApiModelProperty(value = "用户昵称", example = "1")
    private String nickName;
    @ApiModelProperty(value = "手机号码", example = "1321312321213")
    private String phonenumber;
    @ApiModelProperty(value = "状态", example = "0")//0表示正常 1表示停用
    private String status;
    @ApiModelProperty(value = "删除标志", example = "1")//0表示未删除，1表示已删除
    private String delFlag;
    @ApiModelProperty(value = "创建时间", example = "2022-08-24 21：54：31")
    private String createTime;
}
