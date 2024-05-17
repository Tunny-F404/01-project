package com.zeroone.star.project.j2.orgstructure.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.Data;

/**
 * @author: 天衍土豆
 * @data: 2024/5/17
 * @description:
 */
@Data
@ApiOperation("部门传输数据对象")
public class RoleDTO {



    //角色名称
    @ApiModelProperty(value = "角色名称",example = "1")
    private String roleName;


    //角色权限字符串
    @ApiModelProperty(value = "角色权限字符串",example = "1")
    private String roleKey;

    //显示顺序
    @ApiModelProperty(value = "显示顺序",example = "1")
    private Integer roleSort;


    //数据范围（1：全部数据权限 2：自定数据权限 3：本部门数据权限 4：本部门及以下数据权限）
    @ApiModelProperty(value = "数据范围",example = "1")
    private String dataScope;


    //菜单树选择项是否关联显示
    @ApiModelProperty(value = "查询Id",example = "true")
    private Boolean menuCheckStrictly;

}
