package com.zeroone.star.orgstructure.controller;


import com.zeroone.star.project.dto.PageDTO;
import com.zeroone.star.project.j2.orgstructure.dto.role.RoleDTO;
import com.zeroone.star.project.vo.JsonVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
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
public class RoleController {
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

    /*
     * 获取角色分配用户列表（条件+分页）
     * */
    @GetMapping("query-allocate-role")
    @ApiOperation("获取角色分配用户列表（条件+分页）")
    public JsonVO<List<RoleDTO>> queryAllocatedList(@RequestBody RoleDTO roleDTO, @RequestBody PageDTO<RoleDTO> pageDTO) {
        return JsonVO.success(null);
    }

    /*
    * 添加授权
    * */
    @PutMapping("addAuth")
    @ApiOperation("添加授权")
    public JsonVO<RoleDTO> addAuth(@RequestParam Long roleId,@RequestParam Long[] userIds){
        return JsonVO.success(null);
    }

    /*
    * 取消授权（支持批量）
    * */
    @DeleteMapping("cancel")
    @ApiOperation("取消授权")
    public JsonVO<List<RoleDTO>> cancelAuthUser(@RequestParam Long roleId, @RequestParam Long[] userIds){
        return JsonVO.success(null);
    }

    /*
    * 导出角色
    * */
    @PostMapping("export")
    @ApiOperation("导出角色")
    public ResponseEntity<byte[]> export(){
        return new ResponseEntity<>(null,null);
    }
}

