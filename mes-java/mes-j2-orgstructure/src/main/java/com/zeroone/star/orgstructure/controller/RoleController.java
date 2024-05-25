package com.zeroone.star.orgstructure.controller;


import com.zeroone.star.orgstructure.service.IRoleService;
import com.zeroone.star.project.dto.PageDTO;
import com.zeroone.star.project.j2.orgstructure.dto.role.RoleDTO;
import com.zeroone.star.project.j2.orgstructure.query.role.RoleConditionQuery;
import com.zeroone.star.project.j2.orgstructure.dto.role.RoleListDTO;
import com.zeroone.star.project.j2.orgstructure.dto.role.RolePermissionsDTO;
import com.zeroone.star.project.j2.orgstructure.query.role.RolePermissionsQuery;
import com.zeroone.star.project.j2.orgstructure.role.RoleApis;
import com.zeroone.star.project.vo.JsonVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 角色信息表 前端控制器
 * </p>
 *
 * @author 0xu0、天衍土豆
 * @since 2024-05-17
 */
@RestController
@RequestMapping("/orgstructure/role")
@Api(tags = "角色控制器")
public class RoleController implements RoleApis {

    @Autowired
    private IRoleService roleService;
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

    @Override
    public JsonVO<List<RoleDTO>> queryAllocatedList(RoleDTO roleDTO, PageDTO<RoleDTO> pageDTO) {
        return null;
    }

    @Override
    public JsonVO<RoleDTO> addAuth(Long roleId, Long[] userIds) {
        return null;
    }

    @Override
    public JsonVO<List<RoleDTO>> cancelAuthUser(Long roleId, Long[] userIds) {
        return null;
    }

    @Override
    public ResponseEntity<byte[]> export() {
        return null;
    }

}

