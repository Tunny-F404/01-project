package com.zeroone.star.project.j3.sysmanager;


import com.zeroone.star.project.j3.dto.NoticeDTO;

import com.zeroone.star.project.vo.JsonVO;

/**
 * 系统管理-通知公告相关接口
 */

public interface NoticeApis {
    /**
     * 修改通知公告
     *
     * @param noticeDTO
     * @return
     */
    JsonVO<Integer> updateNotice(NoticeDTO noticeDTO);
}
