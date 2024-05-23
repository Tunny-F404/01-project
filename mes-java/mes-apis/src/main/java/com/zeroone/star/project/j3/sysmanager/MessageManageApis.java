package com.zeroone.star.project.j3.sysmanager;

import com.zeroone.star.project.j3.dto.PageDTO;
import com.zeroone.star.project.j3.query.NewsPageQuery;
import com.zeroone.star.project.j3.vo.NewsPageVO;
import com.zeroone.star.project.j3.vo.NewsVO;

/**
 * 系统管理-消息管理相关接口
 */

public interface MessageManageApis {

    /**
     * 根据id查询消息详情
     *
     * @return 消息详情
     */
    NewsVO getNewsById(Integer id);

    /**
     * 分页查询消息列表
     *
     * @return 消息列表
     */
    PageDTO<NewsPageVO> queryNewsList(NewsPageQuery newsPageQuery);
}
