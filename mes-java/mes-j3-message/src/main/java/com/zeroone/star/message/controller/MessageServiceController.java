package com.zeroone.star.message.controller;

import com.zeroone.star.project.j3.messageservice.MessageServiceApis;
import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Api(tags = "消息服务")
@Controller
@RequestMapping("/message-service")
public class MessageServiceController implements MessageServiceApis {
}
