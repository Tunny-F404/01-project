package com.zeroone.star.orgstructure.controller;


import com.zeroone.star.project.dto.PageDTO;
import com.zeroone.star.project.j2.orgstructure.dto.role.RoleDTO;
import com.zeroone.star.project.j2.orgstructure.role.RoleApis;
import com.zeroone.star.project.vo.JsonVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 角色信息表 前端控制器
 * </p>
 *
 * @author tianyantudou
 * @since 2024-05-17
 */
@RestController
@RequestMapping("/orgstructure/role")
@Api(tags = "角色控制器")
public class RoleController implements RoleApis {
    /**
     * 获取角色名称列表
     */
    @GetMapping("query-roles")
    @ApiOperation("获取角色名称列表")
    public JsonVO<List<RoleDTO>> queryRoles() {
        return JsonVO.success(null);
    }

    /**
     * 获取角色列表(条件+分页)
     */
    @GetMapping("/query-page")
    @ApiOperation("获取角色列表(条件+分页)")
    public JsonVO<List<RoleDTO>> queryRolePage(@RequestBody RoleDTO condition, @RequestBody PageDTO<RoleDTO> pageDTO) {
        return JsonVO.success(null);
    }

    /**
     * 获取角色详情
     */
    @GetMapping("query-role")
    @ApiOperation("获取角色详情")
    public JsonVO<RoleDTO> queryRole(@RequestParam Integer id) {
        return JsonVO.success(null);
    }

    /**
     * 设置数据权限
     */
    @GetMapping("modify-role")
    @ApiOperation("设置数据权限")
    public JsonVO<List<RoleDTO>> modifyRole(@RequestParam Integer id) {
        return JsonVO.success(null);
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

}

