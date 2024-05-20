package com.zeroone.star.orgstructure.controller;

import com.zeroone.star.project.j1.orgstructure.dto.user.CompleteUserDTO;
import com.zeroone.star.project.j1.orgstructure.dto.user.UserDTO;
import com.zeroone.star.project.j1.orgstructure.query.user.UserQuery;
import com.zeroone.star.project.j1.orgstructure.user.UserApis;
import com.zeroone.star.project.vo.JsonVO;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>版权：&copy;01星球</p>
 * <p>地址：01星球总部</p>
 * @author Tme
 * @version 1.0.0
 */
@RestController("user")
public class UserController implements UserApis {
    @GetMapping("query-user-table")
    @Override
    @ApiOperation("查询用户列表")
    public JsonVO<List<UserDTO>> queryUserList(UserQuery userQuery) {
        return null;
    }

    @Override
    @GetMapping("query-complete-user")
    @ApiOperation("获取用户详情")
    public JsonVO<CompleteUserDTO> queryUser(UserDTO userDTO) {
        return null;
    }


}
