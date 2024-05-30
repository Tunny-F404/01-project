package com.zeroone.star.orgstructure.controller;


import com.zeroone.star.orgstructure.entity.UserDO;
import com.zeroone.star.orgstructure.service.RoleService;
import com.zeroone.star.project.components.user.UserDTO;
import com.zeroone.star.project.dto.PageDTO;
import com.zeroone.star.project.j2.orgstructure.dto.role.RoleDTO;
import com.zeroone.star.project.j2.orgstructure.dto.role.*;
import com.zeroone.star.project.j2.orgstructure.query.role.RoleConditionQuery;
import com.zeroone.star.project.j2.orgstructure.query.role.RolePermissionsQuery;
import com.zeroone.star.project.j2.orgstructure.role.RoleApis;
import com.zeroone.star.project.vo.JsonVO;
import com.zeroone.star.project.vo.ResultStatus;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 角色信息表 前端控制器
 * </p>
 *
 * @author 0xu0、天衍土豆 迷
 * @since 2024-05-17
 */
@RestController
@RequestMapping("/orgstructure/role")
@Api(tags = "角色控制器")
public class RoleController implements RoleApis {



    @Resource
    private RoleService roleService;
    /**
     *
     * 获取角色名称列表
     * @author 天衍土豆
     * @return
     */
    @Override
    @GetMapping("query-roles")
    @ApiOperation("获取角色名称列表")
    public JsonVO<List<RoleListDTO>> queryRoles() {
        List<RoleListDTO> result = roleService.listRoles();
        return JsonVO.success(result);
    }

    /**
     * 获取角色列表(条件+分页)
     * @author 天衍土豆
     * @return
     */
    @Override
    @GetMapping ("/query-page")
    @ApiOperation("获取角色列表(条件+分页)")
    public JsonVO<PageDTO<RoleListDTO>> queryRolePage(RoleConditionQuery condition) {
        PageDTO<RoleListDTO> result = roleService.listPageRoles(condition);
        return JsonVO.success(result);
    }

    /**
     * 获取角色详情
     * @author 天衍土豆
     * @return
     */
    @Override
    @GetMapping("query-role")
    @ApiOperation("获取角色详情")
    public JsonVO<RoleDTO> queryRole(@RequestParam Integer id) {
        RoleDTO result = roleService.getById(id);
        return JsonVO.success(result);
    }

    /**
     * 设置数据权限回显
     */
    @Override
    @GetMapping("query-role-Permissions")
    @ApiOperation("设置数据权限回显")
    public JsonVO<RolePermissionsDTO> queryRolePermissions(Integer id) {
        RolePermissionsDTO result = roleService.getPermissions(id);
        return JsonVO.success(result);
    }


    /**
     * 设置数据权限
     * @author 天衍土豆
     * @return
     */
    @Override
    @PutMapping("modify-role")
    @ApiOperation("设置数据权限")
    public JsonVO<String> modifyRole(@RequestBody RolePermissionsQuery rolePermissionsQuery) {
        int i = roleService.updatePermissions(rolePermissionsQuery);
        if (i<0){
            return JsonVO.fail("修改失败");
        }
        return JsonVO.success("修改成功");
    }
    /**
     * 添加角色
     * @author 0xu0
     * @param roleDTO
     * @return
     */
    @PostMapping("add-Role")
    @ApiOperation("添加角色")
    public JsonVO<RoleDTO> addRole(@RequestBody RoleDTO roleDTO){
        return JsonVO.success(roleDTO);
    }

    /***
     * 修改角色状态（角色页面，有个开关符号，控制停用和启用）
     * @author 0xu0
     * @param status
     * @return
     */
    @PostMapping("modify-RoleStatus")
    @ApiOperation("修改角色状态")
    public JsonVO<String> modifyRoleStatus(@RequestParam String status){
        return JsonVO.success(status);
    }


    /**
     * 删除角色，支持批量删除
     * @author 0xu0
     * @param id
     * @return
     */
    @DeleteMapping("delete-Roles")
    @ApiOperation("删除角色")
    public JsonVO<Long[]> deleteRoles(@RequestParam Long[] id){
        return JsonVO.success(id);
    }

    /**
     * 修改角色信息
     * @param roleDTO
     * @return
     */
    @PostMapping("modify-RoleInfo")
    @ApiOperation("修改角色信息")
    public JsonVO<RoleDTO> modifyRoleInfo(@RequestBody RoleDTO roleDTO){
        return JsonVO.success(roleDTO);
    }

    /*
     * 获取角色分配用户列表（条件+分页）
     * */
    @GetMapping("query-allocate-role")
    @ApiOperation("获取角色分配用户列表（条件+分页）")
    public JsonVO<List<UserRoleDTO>> queryAllocatedList(@RequestParam Long roleId,
                                                    @RequestParam int page,
                                                    @RequestParam int size) {
        int offset = (page - 1) * size;
        List<UserRoleDTO> users = roleService.getUsersByRoleId(roleId, offset, size);
        if (users != null && !users.isEmpty()) {
            return JsonVO.success(users);
        } else {
            return JsonVO.fail(null);
        }
    }


    /*
     * 添加授权
     * */
    @PutMapping("addAuth")
    @ApiOperation("添加授权")
    public JsonVO<RoleDTO> addAuth(@RequestParam Long roleId, @RequestParam Long[] userIds) {
        Integer result = roleService.insertAuthUsers(roleId, userIds);
        return result > 0 ? JsonVO.success(null) : JsonVO.fail(null);
    }

    /*
     * 取消授权（支持批量）
     * */
    @DeleteMapping("cancel")
    @ApiOperation("批量取消授权")
    public JsonVO<Integer> cancelAuthUsers(@RequestParam Long roleId, @RequestParam Long[] userIds) {
        Integer result = roleService.deleteAuthUsers(roleId, userIds);
        return result > 0 ? JsonVO.success(result) : JsonVO.fail(result);
    }

    /*
     * 导出角色
     * */
    @GetMapping(value = "export")
    @ApiOperation("导出角色")
    public ResponseEntity<byte[]> export() {
        return roleService.downloadExcel();
    }

}

