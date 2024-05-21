package com.zeroone.star.project.j5.teamsettings.dto;

import com.zeroone.star.project.j5.teamsettings.vo.DeptVO;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.List;

/**
 * @Author: Liang
 * @Date: 2024/05/21/20:38
 * @Description:
 */
@Data
@ApiModel("传输数据对象 部门dept的数据")
public class DeptDTO {
    private String searchValue;
    private String createBy;
    private String createTime;
    private String updateBy;
    private String updateTime;
    private String remark;
    private Object params;
    private Integer userId;
    private Integer deptId;
    private String userName;
    private String nickName;
    private String email;
    private String phonenumber;
    private String sex;
    private String avatar;
    private String salt;
    private String status;
    private String delFlag;
    private String loginIp;
    private String loginDate;
    private DeptVO dept;
    private List<String> roles;
    private List<Integer> roleIds;
    private List<Integer> postIds;
    private Integer roleId;
    private Boolean admin;
}
