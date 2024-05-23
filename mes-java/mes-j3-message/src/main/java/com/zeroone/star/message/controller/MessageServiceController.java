package com.zeroone.star.message.controller;

import com.zeroone.star.project.j3.dto.MessageDTO;
import com.zeroone.star.project.j3.messageservice.MessageServiceApis;
import com.zeroone.star.project.j3.query.MessageQuery;
import com.zeroone.star.project.vo.JsonVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags="消息服务")
@RestController
@RequestMapping("/message-service")
public class MessageServiceController implements MessageServiceApis {
    @Override
    @PostMapping("/delete-messages")
    @ApiOperation("删除消息")
    public JsonVO<List<Long>> removeMessages(List<Long> ids) {
        return null;
    }

    @Override
    @GetMapping("/query-messages")
    @ApiOperation(("查询消息"))
    public JsonVO<List<MessageDTO>> queryMessage(MessageQuery query) {
        return null;
    }

    @Override
    @PostMapping("/modify-message")
    @ApiOperation("修改消息状态")
    public JsonVO<List<Long>> modifyMessageStatus(Long id) {
        return null;
    }

}
