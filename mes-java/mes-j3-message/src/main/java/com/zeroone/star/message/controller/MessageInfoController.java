package com.zeroone.star.message.controller;

import com.zeroone.star.project.j3.messageinform.MessageInfoApis;
import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Api(tags = "消息通知")
@Controller
@RequestMapping("/message-info")
public class MessageInfoController implements MessageInfoApis {
}
