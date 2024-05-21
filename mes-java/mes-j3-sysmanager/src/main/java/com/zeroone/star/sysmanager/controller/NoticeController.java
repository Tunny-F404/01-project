package com.zeroone.star.sysmanager.controller;

import com.zeroone.star.project.j3.dto.NoticeDto;
import com.zeroone.star.project.j3.sysmanager.NoticeApis;
import io.swagger.annotations.Api;
import org.hibernate.validator.constraints.pl.REGON;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "通知公告")
@Controller
@RequestMapping("/sys-manager/notice")
public class NoticeController implements NoticeApis {
    @PutMapping("/UpdateNoticeById")
    public NoticeDto UpdateNoticeById(Integer id) {
        return null;
    }
}
