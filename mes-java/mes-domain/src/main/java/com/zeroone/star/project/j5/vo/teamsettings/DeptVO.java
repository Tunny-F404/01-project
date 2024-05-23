package com.zeroone.star.project.j5.vo.teamsettings;

import com.zeroone.star.project.j5.dto.teamsettings.DeptDTO;
import io.swagger.annotations.ApiModelProperty;
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
    @ApiModelProperty(value = "搜索值", example = "1")
    private String searchValue;
    @ApiModelProperty(value = "创建者", example = "1213")
    private String createBy;
    @ApiModelProperty(value = "创建时间", example = "2022-08-24 21：54：31")
    private String createTime;
    @ApiModelProperty(value = "更新者", example = "21231")
    private String updateBy;
    @ApiModelProperty(value = "更新时间", example = "2022-08-24 21：54：31")
    private String updateTime;
    @ApiModelProperty(value = "备注", example = "2022-08-24 21：54：31的时候更新了")
    private String remark;
    @ApiModelProperty(value = "请求参数", example = "1")
    private Object params;
    @ApiModelProperty(value = "部门编号", example = "13231")
    private Integer deptId;
    @ApiModelProperty(value = "父部门编号", example = "13231")
    private Integer parentId;
    @ApiModelProperty(value = "祖级列表", example = "1")
    private String ancestors;
    @ApiModelProperty(value = "部门名称", example = "牛马车间1")
    private String deptName;
    @ApiModelProperty(value = "显示顺序", example = "null")
    private Integer orderNum;
    @ApiModelProperty(value = "负责人", example = "121")
    private String leader;
    @ApiModelProperty(value = "联系电话", example = "13232133123121")
    private String phone;
    @ApiModelProperty(value = "邮箱", example = "13232132@163.com")
    private String email;
    @ApiModelProperty(value = "部门状态", example = "1")
    private String status;
    @ApiModelProperty(value = "删除标记", example = "1")
    private String delFlag;
    @ApiModelProperty(value = "父部门名称", example = "13231")
    private String parentName;
    @ApiModelProperty(value = "子部门列表", example = "['ADMIN','MANAGER']")
    private List<DeptDTO> children;
}
