package com.zeroone.star.sysmanager.controller;

import com.zeroone.star.project.j3.dto.PageDto;
import com.zeroone.star.project.j3.query.NewsPageQuery;
import com.zeroone.star.project.j3.sysmanager.MessageManageApis;
import com.zeroone.star.project.j3.vo.NewsPageVo;
import com.zeroone.star.project.j3.vo.NewsVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Api(tags = "消息管理")
@Controller
@RequestMapping("/sys-manager/message-manager")
public class MessageManageController implements MessageManageApis {
    @GetMapping("/news/{id}")
    @ApiOperation(value = "分析获取消息详情")
    public NewsVo getNewsById(@PathVariable Integer id){
        return null;
    }

    @GetMapping("/news/list")
    @ApiOperation(value = "获取消息列表")
    public PageDto<NewsPageVo> queryNewsList(NewsPageQuery newsPageQuery){
        return null;
    }
}
