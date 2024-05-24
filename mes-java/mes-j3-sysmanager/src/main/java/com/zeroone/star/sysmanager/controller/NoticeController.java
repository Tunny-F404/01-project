package com.zeroone.star.sysmanager.controller;

import com.zeroone.star.project.j3.dto.*;
import com.zeroone.star.project.j3.query.NoticeQuery;
import com.zeroone.star.project.j3.sysmanager.NoticeApis;
import com.zeroone.star.project.j3.vo.NoticeListVo;
import com.zeroone.star.project.vo.JsonVO;
import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.List;

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


    @Override
    @PostMapping("/add-notice")
    @ApiOperation("添加公告")
    public JsonVO<Long> addNotice(addNoticeDto dto) {
        return null;
    }

    @Override
    @PostMapping("/update-notice")
    @ApiOperation("更新公告")
    public JsonVO<Long> updateNotice(UpdateNoticeDto dto) {
        //service.updateById(dto);
        return null;
    }

    @Override
    @PostMapping("/query-noticeListVos-by-condition")
    @ApiOperation("查询公告")
    public JsonVO<List<NoticeListVo>> queryNoticeListVosByCondition(NoticeQuery query) {
        return null;
    }

    @Override
    @PostMapping("/remove-notice")
    @ApiOperation("删除公告")
    public JsonVO<List<Long>> removeNotice(List<Long> ids) {
        return null;
    }

}
