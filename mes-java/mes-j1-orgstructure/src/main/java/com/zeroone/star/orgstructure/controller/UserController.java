package com.zeroone.star.orgstructure.controller;

import com.zeroone.star.project.j1.orgstructure.dto.user.UpdateUserStatusDTO;
import com.zeroone.star.project.j1.orgstructure.user.UserApis;
import com.zeroone.star.project.vo.JsonVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
@Api(tags = "用户管理")
public class UserController implements UserApis {
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

}
