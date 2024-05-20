package com.zeroone.star.mycenter.controller;

import com.zeroone.star.project.j1.mycenter.MyCenterApis;
import com.zeroone.star.project.j1.mycenter.dto.MyCenterDTO;
import com.zeroone.star.project.vo.JsonVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 柱
 * @version 1.0.0
 * @since 2024-5-19
 */
@Slf4j
@RestController
@RequestMapping("/user")
@Api("用户个人中心")
public class MyCenterController implements MyCenterApis {

    @Override
    @PostMapping("/modify-info")
    @ApiOperation("修改个人信息")
    public JsonVO<MyCenterDTO> modifyInfo(MyCenterDTO myCenterDTO) {
        return JsonVO.success(myCenterDTO);
    }

    @Override
    @PostMapping("/modify-avatar")
    @ApiOperation("修改头像")
    public JsonVO<String> modifyAvatar(String PattenUrl) {
        return null;
    }

    @Override
    @PostMapping("/modify-phone")
    @ApiOperation("修改手机")
    public JsonVO<String> modifyPhone(String Phone) {
        return null;
    }

    @Override
    @PostMapping("/modify-email")
    @ApiOperation("修改邮箱")
    public JsonVO<String> modifyEmail(String Email) {
        return null;
    }

    @Override
    @PostMapping("/modify-password")
    @ApiOperation("修改密码")
    public JsonVO<String> modifyPassword(String Password) {
        return null;
    }
}
