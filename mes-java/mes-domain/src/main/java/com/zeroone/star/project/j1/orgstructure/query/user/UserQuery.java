package com.zeroone.star.project.j1.orgstructure.query.user;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.time.LocalDateTime;

/**
 * 用户数据模型
 */
@Data
@ApiModel("新增用户")
public class UserQuery {
    @ApiModelProperty(value = "用户ID", example = "1")
    private Long userId;
    @ApiModelProperty(value = "部门ID", example = "4")
    private Long deptId;
    @ApiModelProperty(value = "用户账户", example = "admin")
    private String userName;
    @ApiModelProperty(value = "用户昵称", example = "管理员")
    private String nickName;
    @ApiModelProperty(value = "用户类型 00为系统用户", example = "00")
    private String userType;
    @ApiModelProperty(value = "用户邮箱", example = "admin@163.com")
    private String email;
    @ApiModelProperty(value = "手机号码", example = "13299106672")
    private String phonenumber;
    @ApiModelProperty(value = "用户性别 0男 1女 2未知", example = "0")
    private char sex;
    @ApiModelProperty(value = "头像地址", example = "/profile/avatar/2024/04/11/blob_20240411220241A003.jpeg")
    private String avatar;
    @ApiModelProperty(value = "密码", example = "123456")
    private String password;
    @ApiModelProperty(value = "账号状态 0正常 1停用", example = "0")
    private char status;
    @ApiModelProperty(value = "删除标志 0存在 1删除", example = "0")
    private char delFlag;
    @ApiModelProperty(value = "最后登录IP", example = "127.0.0.1")
    private String loginIp;
    @ApiModelProperty(value = "最后登录时间", example = "2024-04-11 16:58:05")
    private LocalDateTime loginDate;
    @ApiModelProperty(value = "创建者", example = "admin")
    private String createBy;
    @ApiModelProperty(value = "创建时间", example = "2022-04-07 00:29:31")
    private LocalDateTime createTime;
    @ApiModelProperty(value = "更新者", example = "admin")
    private String updateBy;
    @ApiModelProperty(value = "更新时间", example = "2024-04-11 16:58:02")
    private LocalDateTime updateTime;
    @ApiModelProperty(value = "备注", example = "管理员")
    private String remark;
}
