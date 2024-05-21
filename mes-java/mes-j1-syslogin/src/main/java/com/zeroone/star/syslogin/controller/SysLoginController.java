package com.zeroone.star.syslogin.controller;

import com.zeroone.star.project.j1.syslogin.SysLoginApis;
import com.zeroone.star.project.j1.syslogin.vo.CurrentUserInfoVO;
import com.zeroone.star.project.j1.syslogin.vo.CurrentUserMenuVO;
import com.zeroone.star.project.vo.JsonVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "登录系统")
@RequestMapping("syslogin")
@RestController
public class SysLoginController extends SysLoginApis {
	@Override
	@GetMapping("getCurrentUserMenu")
	@ApiOperation("获取当前用户菜单")
	public JsonVO<List<CurrentUserMenuVO>> getCurrentUserMenu(Integer userId) {
		return null;
	}

	@Override
	@GetMapping("getCurrentUserInfo")
	@ApiOperation("获取当前用户信息")
	public JsonVO<CurrentUserInfoVO> getCurrentUserInfo(Integer userId) {
		return null;
	}
}
