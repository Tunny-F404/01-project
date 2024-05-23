package com.zeroone.star.project.j3.sysmanager;

import com.zeroone.star.project.j3.dto.NoticeDTO;

/**
 * 系统管理-通知公告相关接口
 */

public interface NoticeApis {
    /**
     * 根据id查询通知公告并修改
     * @param id 通知公告id
     * @return 通知公告
     */
    NoticeDTO UpdateNoticeById(Integer id);
}
