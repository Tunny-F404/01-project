package com.zeroone.star.project.j3.sysmanager;

import com.zeroone.star.project.j3.vo.NoticeVO;
import com.zeroone.star.project.vo.JsonVO;

/**
 * 系统管理-通知公告相关接口
 */

public interface NoticeApis {
    /**
     * 修改通知公告
     *
     * @param noticeVO
     * @return
     */
    JsonVO updateNotice(NoticeVO noticeVO);
}
