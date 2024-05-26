package com.zeroone.star.message.controller;

import com.zeroone.star.message.service.ISysMessageService;
import com.zeroone.star.project.dto.PageDTO;
import com.zeroone.star.project.j3.dto.SysMessageDTO;
import com.zeroone.star.project.j3.dto.SysUpdateMessageDTO;
import com.zeroone.star.project.j3.messageinform.MessageInfoApis;
import com.zeroone.star.project.j3.query.MessageQuery;
import com.zeroone.star.project.j3.query.NewsPageQuery;
import com.zeroone.star.project.j3.vo.SysMessageVO;
import com.zeroone.star.project.j3.vo.UnreadMessageVO;
import com.zeroone.star.project.vo.JsonVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "消息通知")
@Controller
@RequestMapping("/message-info")
@ResponseBody
public class MessageInfoController implements MessageInfoApis {

    @Autowired
    private ISysMessageService messageService;

    @Override
    @PostMapping("/delete-messages")
    @ApiOperation("删除消息")
    public JsonVO<List<Long>> removeMessages(@RequestBody List<Long> ids) {
        List<Long> data = messageService.removeMessages(ids);
        return !data.isEmpty() ? JsonVO.success(data) : JsonVO.fail(data);
    }

    @Override
    @GetMapping("/query-messages")
    @ApiOperation(("查询消息"))
    public JsonVO<List<SysMessageDTO>> queryMessage(@RequestBody MessageQuery query) {
        List<SysMessageDTO> data = messageService.queryMessage(query);
        return JsonVO.success(data);
    }

    @Override
    @PostMapping("/modify-message")
    @ApiOperation("修改消息状态")
    public JsonVO<List<Long>> modifyMessageStatus(Long id) {
        List<Long> data = messageService.modifyMessage(id);
        return !data.isEmpty() ? JsonVO.success(data) : JsonVO.fail(data);
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
