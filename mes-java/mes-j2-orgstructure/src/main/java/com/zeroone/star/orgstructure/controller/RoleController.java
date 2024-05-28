package com.zeroone.star.orgstructure.controller;


import com.zeroone.star.orgstructure.service.RoleService;
import com.zeroone.star.project.components.easyexcel.EasyExcelComponent;
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
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.management.relation.Role;
import java.io.ByteArrayOutputStream;
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
    private RoleService roleServiceImpl;
    @Resource
    private EasyExcelComponent excel;

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
     *
     * @param roleDTO
     * @return
     * @author 0xu0
     */
    @PostMapping("add-Role")
    @ApiOperation("添加角色")
    public JsonVO<Integer> addRole(RoleAddDto roleDTO) {
        Integer add = roleServiceImpl.addRole(roleDTO);
        if (add > 0) {
            return JsonVO.success(add);
        }
        return JsonVO.fail(add);
    }

    /***
     * 修改角色状态（角色页面，有个开关符号，控制停用和启用）
     * @author 0xu0
     * @param roleStatusModifyDto
     * @return
     */
    @PostMapping("modify-RoleStatus")
    @ApiOperation("修改角色状态")
    public JsonVO<Integer> modifyRoleStatus(RoleStatusModifyDto roleStatusModifyDto) {
        Integer modify = roleServiceImpl.modifyRoleStatus(roleStatusModifyDto);
        if (modify > 0) {
            return JsonVO.success(modify);
        }
        return JsonVO.fail(modify);
    }


    /**
     * 删除角色，支持批量删除
     *
     * @param ids
     * @return
     * @author 0xu0
     */
    @DeleteMapping("delete-Roles")
    @ApiOperation("删除角色")
    public JsonVO<List<String>> deleteRoles(@RequestParam List<String> ids) {
        if (roleServiceImpl.deleteRoles(ids) > 0) {
            return JsonVO.success(ids);
        }
        return JsonVO.fail(ids);
    }

    /**
     * 修改角色信息
     *
     * @param roleDTO
     * @return
     */
    @PostMapping("modify-RoleInfo")
    @ApiOperation("修改角色信息")
    public JsonVO<Integer> modifyRoleInfo(RoleModifyDto roleDTO) {
        Integer info = roleServiceImpl.modifyRoleInfo(roleDTO);
        System.out.println(info);
        if (info > 0) {
            return JsonVO.success(info);
        }
        return JsonVO.fail(info);
    }

    /*@Override
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
    }*/
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
    public JsonVO<RoleDTO> addAuth(@RequestParam Long roleId, @RequestParam Long[] userIds) {
        return JsonVO.success(null);
    }

    /*
     * 取消授权（支持批量）
     * */
    @DeleteMapping("cancel")
    @ApiOperation("取消授权")
    public JsonVO<List<RoleDTO>> cancelAuthUser(@RequestParam Long roleId, @RequestParam Long[] userIds) {
        return JsonVO.success(null);
    }

    /*
     * 导出角色
     * */
    @PostMapping("export")
    @ApiOperation("导出角色")
    public ResponseEntity<byte[]> export() {

        /*ByteArrayOutputStream out = new ByteArrayOutputStream();
        excel.export("角色列表",out, RoleDTO.class,);*/
        return new ResponseEntity<>(null, null);
    }

}

