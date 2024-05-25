package com.zeroone.star.project.j2.orgstructure.dto.role;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.Data;

/**
 * 描述：修改角色状态传输对象(角色管理页面中，状态开关）
 *
 * @author 0xu0
 * @version 1.0.0
 */
@Data
@ApiOperation("修改角色状态传输对象")
public class RoleStatusModifyDto {
    @ApiModelProperty(value = "角色编号",example = "1")
    private Integer roleId;
    @ApiModelProperty(value = "角色状态(0正常，1停用）",example = "0")
    private String status;
}
