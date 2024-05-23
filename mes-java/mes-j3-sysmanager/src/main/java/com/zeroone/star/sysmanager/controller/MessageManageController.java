package com.zeroone.star.sysmanager.controller;

import com.zeroone.star.project.j3.dto.PageDTO;
import com.zeroone.star.project.j3.query.NewsPageQuery;
import com.zeroone.star.project.j3.sysmanager.MessageManageApis;
import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.zeroone.star.project.j3.vo.NewsPageVO;
import com.zeroone.star.project.j3.vo.NewsVO;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Api(tags = "消息管理")
@Controller
@RequestMapping("sys-manager/message-manager")
public class MessageManageController implements MessageManageApis {
    @GetMapping("/news/{id}")
    @ApiOperation(value = "消息详情")
    public NewsVO getNewsById(@PathVariable Integer id) {
        return null;
    }

    @GetMapping("/news/list")
    @ApiOperation(value = "消息列表")
    public PageDTO<NewsPageVO> queryNewsList(NewsPageQuery newsPageQuery) {
        return null;
    }
}
