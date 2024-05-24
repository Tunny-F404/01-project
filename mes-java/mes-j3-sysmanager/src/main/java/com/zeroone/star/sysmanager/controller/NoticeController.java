package com.zeroone.star.sysmanager.controller;

import com.zeroone.star.project.j3.dto.NoticeDTO;
import com.zeroone.star.project.dto.login.LoginDTO;
import com.zeroone.star.project.j3.dto.LogoutDTO;
import com.zeroone.star.project.j3.dto.SystemNotificationDTO;
import com.zeroone.star.project.j3.sysmanager.NoticeApis;
import com.zeroone.star.project.vo.JsonVO;
import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PutMapping;
import com.zeroone.star.project.vo.ResultStatus;
import com.zeroone.star.project.vo.login.LoginVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "通知公告")
@Controller
@RequestMapping("sys-manager/notice")
public class NoticeController implements NoticeApis {
    /**
     * 修改通知公告
     *
     * @param noticeDTO
     * @return
     */
    @PutMapping("/update")
    @ApiOperation(value = "修改通知公告")
    public JsonVO<Integer> updateNotice(@RequestBody NoticeDTO noticeDTO) {
        return null;
    }

}
