package com.zeroone.star.sysmanager.controller;

import com.zeroone.star.project.j3.sysmanager.NoticeApis;
import com.zeroone.star.project.j3.vo.NoticeVO;
import com.zeroone.star.project.vo.JsonVO;
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
    /**
     * 修改通知公告
     *
     * @param noticeVO
     * @return
     */
    @PutMapping("/update")
    @ApiOperation(value = "修改通知公告")
    public JsonVO updateNotice(@RequestBody NoticeVO noticeVO) {
        return null;
    }
}
