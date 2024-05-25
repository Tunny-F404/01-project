package com.zeroone.star.orgstructure.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * sys_user表的所有字段
 */
@Data
@TableName("sys_user")
public class User {
	//用户ID
	private Long user_id;
	//部门ID
	private Long dept_Id;
	//用户账号
	private String user_name;
	//用户昵称
	private String nick_name;
	//用户类型（00系统用户）
	private String user_type;
	//用户邮箱
	private String email;
	//手机号码
	private String phonenumber;
	//用户性别（0男 1女 2未知）
	private String sex;
	//头像地址
	private String avatar;
	//密码
	private String password;
	//帐号状态（0正常 1停用）
	private String status;
	//删除标志（0代表存在 2代表删除）
	private String del_flag;
	//最后登录IP
	private String login_ip;
	//最后登录时间
	private String login_date;
	//创建者
	private String create_by;
	//创建时间
	private String create_time;
	//更新者
	private String update_by;
	//更新时间
	private String update_time;
}
