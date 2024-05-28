package com.zeroone.star.orgstructure.controller;

import com.zeroone.star.orgstructure.service.UserService;
import com.zeroone.star.project.j1.orgstructure.dto.PageDTO;
import com.zeroone.star.project.j1.orgstructure.dto.user.*;
import com.zeroone.star.project.j1.orgstructure.query.user.UserQuery;
import com.zeroone.star.project.j1.orgstructure.user.UserApis;
import com.zeroone.star.project.vo.JsonVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * <p>版权：&copy;01星球</p>
 * <p>地址：01星球总部</p>
 *
 * @author Tme
 * @version 1.0.0
 */
@Slf4j
@RestController
@RequestMapping("/user")
@Api(tags = "用户管理")
public class UserController implements UserApis {
    @Autowired
    private UserService userService;

    @Override
    @GetMapping("/query-user-table")
    @ApiOperation("查询用户列表")
    public JsonVO<List<UserDTO>> queryUserList(@Valid UserQuery userQuery) {
        List<UserDTO> userDTOS = userService.queryUserList(userQuery);
        return JsonVO.success(userDTOS);
    }

    @Override
    @GetMapping("/query-complete-user")
    @ApiOperation("获取用户详情")
    public JsonVO<CompleteUserDTO> queryUser(UserDTO userDTO) {
        return null;
    }


    @PutMapping("setUserStatus")
    @ApiOperation("设置用户状态")
    @Override
    public JsonVO setUserStatus(UpdateUserStatusDTO userDTO) {
        return null;
    }

    @PutMapping("resetUserPassword")
    @ApiOperation("重置用户密码")
    @Override
    public JsonVO resetUserPassword() {
        return null;
    }


    @GetMapping("query-role-table")
    @ApiOperation(value = "查询角色列表")
    @Override
    public JsonVO<PageDTO<UserDTO>> queryRoleList(UserQuery userQuery) {
        return null;
    }

    @GetMapping("query-user-role-table")
    @ApiOperation(value = "查询用户分配角色列表")
    @Override
    public JsonVO<PageDTO<UserDTO>> queryUserRoleList(String UserName) {
        return null;
    }

    @PutMapping("modify-add-role")
    @ApiOperation(value = "添加角色")
    @Override
    public JsonVO<UserDTO> modifyAddRole(UserQuery userQuery) {
        return null;
    }

    @PutMapping("modify-delete-role")
    @ApiOperation(value = "取消角色")
    @Override
    public JsonVO<UserDTO> modifyDeleteRole(UserQuery userQuery) {
        return null;
    }


    @PostMapping("add-user")
    @ApiOperation(value = "新增用户")
    @Override
    public JsonVO<String> addUser(AddUserDTO addUserDTO) {
        return null;
    }

    @PutMapping("modify-user")
    @ApiOperation(value = "修改用户")
    @Override
    public JsonVO<String> modifyUser(UpdateUserDTO updateUserDTO) {
        return null;
    }

    @DeleteMapping("remove-user")
    @ApiOperation(value = "删除用户")
    @Override
    public JsonVO<String> removeUser(Long[] userIds) {
        return null;
    }

}
