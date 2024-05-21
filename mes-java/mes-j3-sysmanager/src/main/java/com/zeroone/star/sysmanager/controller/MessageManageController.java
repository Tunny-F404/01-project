package com.zeroone.star.sysmanager.controller;

import com.zeroone.star.project.j3.sysmanager.MessageManageApis;
import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Api(tags = "消息管理")
@Controller
@RequestMapping("sys-manager/message-manager")
public class MessageManageController implements MessageManageApis {
}
