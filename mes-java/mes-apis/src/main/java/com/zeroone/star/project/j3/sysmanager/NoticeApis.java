package com.zeroone.star.project.j3.sysmanager;


import com.zeroone.star.project.j3.dto.*;

import com.zeroone.star.project.j3.query.NoticeQuery;
import com.zeroone.star.project.j3.vo.NoticeListVo;
import com.zeroone.star.project.vo.JsonVO;

import com.zeroone.star.project.dto.login.LoginDTO;
import com.zeroone.star.project.vo.ResultStatus;
import com.zeroone.star.project.vo.login.LoginVO;

import java.util.List;

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
    /**
     * 新增公告(notice)
     * @param dto 新增数据
     * @return 新增数据的唯一编号
     */
    JsonVO<Long> addNotice(addNoticeDto dto);
    /**
     * 修改公告(notice)
     * @param dto 新增数据
     * @return 新增数据的唯一编号
     */
    JsonVO<Long> updateNotice(UpdateNoticeDto dto);
    /**
     * 根据给定的公告获取对应的公告数据列表
     * @param query 查询条件对象
     * @return 对应的公告数据列表
     */
    JsonVO<List<NoticeListVo>> queryNoticeListVosByCondition(NoticeQuery query);
    /**
     * 批量删除公告(notices)
     * @param ids 数据ID集合
     * @return 删除结果(-1 失败,1 成功)
     */
    JsonVO<List<Long>> removeNotice(List<Long> ids);
}
