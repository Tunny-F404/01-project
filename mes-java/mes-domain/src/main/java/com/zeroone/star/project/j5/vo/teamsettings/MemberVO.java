package com.zeroone.star.project.j5.vo.teamsettings;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author: Liang
 * @Date: 2024/05/21/19:05
 * @Description:班组成员的数图对象
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberVO {
    @ApiModelProperty(value = "搜索值", example = "1")
    private String searchValue;
    @ApiModelProperty(value = "创建者", example = "1")
    private String createBy;
    @ApiModelProperty(value = "创建时间", example = "2022-08-24 21：54：31")
    private String createTime;
    @ApiModelProperty(value = "更新者", example = "1")
    private String updateBy;
    @ApiModelProperty(value = "更新时间", example = "2022-08-24 21：54：31")
    private String updateTime;
    @ApiModelProperty(value = "备注", example = "备注的意思")
    private String remark;
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
    @ApiModelProperty(value = "邮箱", example = "1")
    private String email;
    @ApiModelProperty(value = "手机号码", example = "1321312321213")
    private String phonenumber;
    @ApiModelProperty(value = "性别", example = "1")//1代表男 0代表女
    private String sex;
    @ApiModelProperty(value = "头像", example = "1")
    private String avatar;
    @ApiModelProperty(value = "盐值", example = "1")//用于加密
    private String salt;
    @ApiModelProperty(value = "状态", example = "0")//0表示正常 1表示停用
    private String status;
    @ApiModelProperty(value = "删除标志", example = "1")//0表示未删除，1表示已删除
    private String delFlag;
    @ApiModelProperty(value = "登录IP", example = "1231231321")
    private String loginIp;
    @ApiModelProperty(value = "登陆日期", example = "1999-10-13")
    private String loginDate;
    @ApiModelProperty(value = "部门的id", example = "1")
    private DeptVO dept;
    @ApiModelProperty(value = "角色列表", example = "['ADMIN','MANAGER']")
    private List<String> roles;
    @ApiModelProperty(value = "角色id列表", example = "['A123','M123']")
    private List<Integer> roleIds;
    @ApiModelProperty(value = "职位id列表", example = "['1','2']")
    private List<Integer> postIds;
    @ApiModelProperty(value = "角色id", example = "1")
    private Integer roleId;
    @ApiModelProperty(value = "是否为管理员", example = "false")
    private Boolean admin;
}
