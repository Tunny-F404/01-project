package com.zeroone.star.project.j5.vo.teamsettings;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author: Liang
 * @Date: 2024/05/21/20:26
 * @Description:部门的对象的视图对象
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeptVO {
    private String searchValue;
    private String createBy;
    private String createTime;
    private String updateBy;
    private String updateTime;
    private String remark;
    private Object params;
    private Integer deptId;
    private Integer parentId;
    private String ancestors;
    private String deptName;
    private Integer orderNum;
    private String leader;
    private String phone;
    private String email;
    private String status;
    private String delFlag;
    private String parentName;
    private List<String> children;
}
