package com.zeroone.star.orgstructure.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;

/**
 * 描述：Role表
 *
 * @author 0xu0
 * @version 1.0.0
 */
@Data
@TableName("sys_role")
public class RoleDo {
    /**
     * 角色ID
     */
    @TableId(value = "role_id",type = IdType.AUTO)
    private Integer roleId;

    /**
     * 角色名称
     */
    @NotNull(message = "角色名称不能为空")
    private String roleName;

    /**
     * 角色权限字符串
     */
    @NotNull(message = "角色权限字符串不能为空")
    private String roleKey;

    /**
     * 显示顺序
     */
    @NotNull(message = "角色显示顺序不能为空")
    private Integer roleSort;

    /**
     * 数据范围（1：全部数据权限 2：自定数据权限 3：本部门数据权限 4：本部门及以下数据权限）
     */
    @Pattern(regexp = "1|2|3|4", message = "输入错误,1：全部数据权限 2：自定数据权限 3：本部门数据权限 4：本部门及以下数据权限")
    private String dataScope;

    /**
     * 菜单树选择项是否关联显示
     */
    private Boolean menuCheckStrictly;

    /**
     * 部门树选择项是否关联显示
     */
    private String deptCheckStrictly;

    /**
     * 角色状态（0正常 1停用）
     */
    @NotNull(message = "角色状态仅能为0或1")
    @Pattern(regexp = "0|1", message = "角色状态仅能为0或1")
    private String status;

    /**
     * 删除标志（0代表存在 2代表删除）
     */
    @Pattern(regexp = "0|2", message = "角色状态仅能为0或2,0代表存在 2代表删除")
    @TableLogic(value = "0",delval = "2")
    private String delFlag;

    /**
     * 创建者
     */
    private String createBy;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新者
     */
    private String updateBy;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 备注
     */
    private String remark;
}
