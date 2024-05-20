package com.zeroone.star.orgstructure.controller;

import com.zeroone.star.project.j1.orgstructure.dto.user.UserDTO;
import com.zeroone.star.project.j1.orgstructure.query.user.UserQuery;
import com.zeroone.star.project.j1.orgstructure.user.UserApis;
import com.zeroone.star.project.vo.JsonVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("User")
@Api(tags ="用户管理")
public class UserController implements UserApis {
    @GetMapping("query-role-table")
    @ApiOperation(value = "查询角色列表")
    @Override
    public JsonVO<List<UserDTO>> queryRoleList(UserQuery userQuery) {
        return null;
    }
    @GetMapping("query-user-role-table")
    @ApiOperation(value = "查询用户分配角色列表")
    @Override
    public JsonVO<List<UserDTO>> queryUserRoleList(UserQuery userQuery) {
        return null;
    }
    @PutMapping("modify-add-role")
    @ApiOperation(value = "添加角色")
    @Override
    public JsonVO<UserDTO> modifyAddRole(List id) {
        return null;
    }
    @PutMapping("modify-delete-role")
    @ApiOperation(value = "取消角色")
    @Override
    public JsonVO<UserDTO> modifyDeleteRole(List id) {
        return null;

    }
}
