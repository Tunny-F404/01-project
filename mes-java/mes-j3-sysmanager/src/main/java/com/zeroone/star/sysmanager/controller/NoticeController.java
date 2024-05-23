package com.zeroone.star.sysmanager.controller;

import com.zeroone.star.project.j3.dto.NoticeDto;
import com.zeroone.star.project.j3.sysmanager.NoticeApis;
import io.swagger.annotations.Api;
import org.hibernate.validator.constraints.pl.REGON;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.hibernate.validator.constraints.pl.REGON;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "通知公告")
@Controller
@RequestMapping("sys-manager/notice")
public class NoticeController implements NoticeApis {
    @PutMapping("/update")
    @ApiOperation(value = "修改公告")
    public NoticeDto UpdateNoticeById(Integer id) {
        return null;
    }
}
