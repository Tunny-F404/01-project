package com.zeroone.star.sysmanager.controller;

import com.zeroone.star.project.dto.login.LoginDTO;
import com.zeroone.star.project.j3.dto.LogoutDTO;
import com.zeroone.star.project.j3.dto.SystemNotificationDTO;
import com.zeroone.star.project.j3.sysmanager.NoticeApis;
import com.zeroone.star.project.vo.ResultStatus;
import com.zeroone.star.project.vo.login.LoginVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "系统通知接口")
@RestController
@RequestMapping("/api/system-notice")
public class NoticeController implements NoticeApis {
    @ApiOperation("客户端登录")
    @PostMapping("/login")
    public LoginVO clientLogin(@ApiParam("登录信息") @RequestBody LoginDTO loginDTO) {
        return null;
    }

    @ApiOperation("客户端退出")
    @PostMapping("/logout")
    public ResultStatus clientLogout(@ApiParam("退出信息") @RequestBody LogoutDTO logoutDTO) {
        return null;
    }

    @ApiOperation("发送系统通知")
    @PostMapping("/send-notice")
    public ResultStatus sendNotice(@ApiParam("系统通知消息") @RequestBody SystemNotificationDTO systemNotificationDTO) {
        return null;
    }
}
