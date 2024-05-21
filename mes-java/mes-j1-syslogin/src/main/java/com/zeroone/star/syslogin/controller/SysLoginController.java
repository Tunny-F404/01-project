package com.zeroone.star.syslogin.controller;

import com.zeroone.star.project.constant.AuthConstant;
import com.zeroone.star.project.dto.login.LoginDTO;
import com.zeroone.star.project.dto.login.Oauth2TokenDTO;
import com.zeroone.star.project.j1.syslogin.SysLoginApis;
import com.zeroone.star.project.j1.syslogin.dto.SysLoginDTO;
import com.zeroone.star.project.vo.JsonVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
@RestController
@RequestMapping("login")
@Api(tags = "登录相关的接口")
public class SysLoginController implements SysLoginApis {

    @Override
    @GetMapping
    @ApiOperation("登录的接口")
    public JsonVO<String> logout() {
        return null;
    }

    @Override
    @GetMapping
    @ApiOperation("退出的接口")
    public JsonVO<Boolean> userLogin(SysLoginDTO loginDTO) {
        return null;
    }
}
