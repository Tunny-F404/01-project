package com.zeroone.star.orgstructure.controller;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import com.zeroone.star.project.j1.orgstructure.dto.user.CompleteUserDTO;
import com.zeroone.star.project.j1.orgstructure.dto.user.UserDTO;
import com.zeroone.star.project.j1.orgstructure.query.user.UserQuery;
import com.zeroone.star.project.j1.orgstructure.user.UserApis;
import com.zeroone.star.project.vo.JsonVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>版权：&copy;01星球</p>
 * <p>地址：01星球总部</p>
 * @author Tme
 * @version 1.0.0
 */
@Slf4j
@RestController
@RequestMapping("/user")
@Api(tags = "用户管理")
public class UserController implements UserApis {
    @Override
    @GetMapping("/query-user-table")
    @ApiOperation("查询用户列表")
    public JsonVO<List<UserDTO>> queryUserList(UserQuery userQuery) {
        return null;
    }

    @Override
    @GetMapping("/query-complete-user")
    @ApiOperation("获取用户详情")
    public JsonVO<CompleteUserDTO> queryUser(UserDTO userDTO) {
        return null;
    }


}
