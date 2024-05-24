package com.zeroone.star.message.controller;

import com.zeroone.star.project.dto.PageDTO;
import com.zeroone.star.project.j3.dto.MessageDTO;
import com.zeroone.star.project.j3.messageinform.MessageInfoApis;
import com.zeroone.star.project.j3.query.MessageQuery;
import com.zeroone.star.project.j3.query.NewsPageQuery;
import com.zeroone.star.project.j3.vo.SysMessageVO;
import com.zeroone.star.project.j3.vo.UnreadMessageVO;
import com.zeroone.star.project.vo.JsonVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Api(tags = "消息通知")
@Controller
@RequestMapping("/message-info")
public class MessageInfoController implements MessageInfoApis {
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

    /**
     * 获取消息列表
     * @param newsPageQuery
     * @return
     */
    @GetMapping("/query-page")
    @ApiOperation("获取消息列表")
    public JsonVO<PageDTO<SysMessageVO>> PageQuerySysMessage(NewsPageQuery newsPageQuery) {
        return null;
    }


    /**
     * 获取最新未读消息列表
     * @return
     */
    @GetMapping("/unread-message")
    @ApiOperation("获取最新未读消息列表")
    public JsonVO<UnreadMessageVO> listUnreadMessage() {
        return null;
    }


}
