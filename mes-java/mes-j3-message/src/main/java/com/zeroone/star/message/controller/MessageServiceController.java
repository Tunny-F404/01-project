package com.zeroone.star.message.controller;

import com.zeroone.star.project.j3.dto.PageDto;
import com.zeroone.star.project.j3.messageservice.MessageServiceApis;
import com.zeroone.star.project.j3.query.NewsPageQuery;
import com.zeroone.star.project.j3.vo.NewsPageVo;
import com.zeroone.star.project.j3.vo.NewsVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Api(tags = "消息服务")
@Controller
@RequestMapping("/message-service")
public class MessageServiceController implements MessageServiceApis {
}
