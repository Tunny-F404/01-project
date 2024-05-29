package com.zeroone.star.orgstructure.controller;


import com.zeroone.star.orgstructure.service.RoleService;
import com.zeroone.star.project.dto.PageDTO;
import com.zeroone.star.project.j2.orgstructure.dto.role.RoleAddDto;
import com.zeroone.star.project.j2.orgstructure.dto.role.RoleModifyDto;
import com.zeroone.star.project.j2.orgstructure.dto.role.RoleStatusModifyDto;
import com.zeroone.star.project.j2.orgstructure.dto.role.RoleDTO;
import com.zeroone.star.project.j2.orgstructure.role.RoleApis;
import com.zeroone.star.project.vo.JsonVO;
import com.zeroone.star.project.vo.ResultStatus;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
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
@Validated//参数校验的,RoleApis上也有-0xu0
public class RoleController implements RoleApis {
    @Resource
    private RoleService roleServiceImpl;
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
    public JsonVO<Integer> addRole(@RequestBody @Valid RoleAddDto roleDTO) {
        Integer add = roleServiceImpl.addRole(roleDTO);
        if (add > 0) {
            return JsonVO.success(add);
        }
        return JsonVO.fail(-1);
    }
    /***
     * 修改角色状态（角色页面，有个开关符号，控制停用和启用）
     * @author 0xu0
     * @param roleStatusModifyDto
     * @return
     */
    @PostMapping("modify-RoleStatus")
    @ApiOperation("修改角色状态")
    public JsonVO<Integer> modifyRoleStatus(@RequestBody @Valid RoleStatusModifyDto roleStatusModifyDto){
        Integer modify = null;
        try {
            modify = roleServiceImpl.modifyRoleStatus(roleStatusModifyDto);
            return JsonVO.success(modify);
        } catch (Exception e) {
            return JsonVO.fail(-1);
        }
//        if(modify>0){
//            return JsonVO.success(modify);
//        }
//        return JsonVO.fail(modify);
    }


    /**
     * 删除角色，支持批量删除
     * @author 0xu0
     * @param ids
     * @return
     */
    @DeleteMapping("delete-Roles")
    @ApiOperation("删除角色")
    public JsonVO<List<String>> deleteRoles(@RequestParam List<String> ids){
        if(roleServiceImpl.deleteRoles(ids)>0){
            return JsonVO.success(ids);
        }
        return JsonVO.fail(ids);
    }

    /**
     * 修改角色信息
     * @param roleDTO
     * @return
     */
    @PostMapping("modify-RoleInfo")
    @ApiOperation("修改角色信息")
    public JsonVO<Integer> modifyRoleInfo(@RequestBody @Valid RoleModifyDto roleDTO){
        Integer info = null;
        try {
            info = roleServiceImpl.modifyRoleInfo(roleDTO);
            return JsonVO.success(info);
        } catch (Exception e) {
           return JsonVO.fail(-1);
        }
//        if(info>0){
//            return JsonVO.success(info);
//        }
//        return JsonVO.fail(info);
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

