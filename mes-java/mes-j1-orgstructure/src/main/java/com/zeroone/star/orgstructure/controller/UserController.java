package com.zeroone.star.orgstructure.controller;

import com.zeroone.star.project.j1.orgstructure.query.user.UserQuery;
import com.zeroone.star.project.j1.orgstructure.user.UserApis;
import com.zeroone.star.project.vo.JsonVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
@Api(tags = "用户管理")
public class UserController implements UserApis {
    @PostMapping("add-user")
    @ApiOperation(value = "新增用户")
    @Override
    public JsonVO<String> addUser(UserQuery userQuery) {
        return null;
    }

    @PutMapping("update-user")
    @ApiOperation(value = "修改用户")
    @Override
    public JsonVO<String> updateUser(UserQuery userQuery) {
        return null;
    }

    @DeleteMapping("delete-user")
    @ApiOperation(value = "删除用户")
    @Override
    public JsonVO<String> deleteUser(Long[] userIds) {
        return null;
    }
}
