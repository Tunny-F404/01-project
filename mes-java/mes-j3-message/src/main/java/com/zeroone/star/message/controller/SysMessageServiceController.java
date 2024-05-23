package com.zeroone.star.message.controller;

import com.zeroone.star.project.j3.messageservice.MessageServiceApis;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "消息服务")
@RequestMapping("/message-service")
@RestController
@ResponseBody
public class SysMessageServiceController implements MessageServiceApis {

}



