package com.zeroone.star.sysmanager.controller;

import com.zeroone.star.project.j3.dto.NoticeDTO;
import com.zeroone.star.project.j3.sysmanager.NoticeApis;
import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PutMapping;

@Api(tags = "通知公告")
@Controller
@RequestMapping("sys-manager/notice")
public class NoticeController implements NoticeApis {
    @PutMapping("/update")
    @ApiOperation(value = "修改通知公告")
    public NoticeDTO updateNotice(@RequestBody NoticeDTO noticeDTO) {
        return null;
    }
}
