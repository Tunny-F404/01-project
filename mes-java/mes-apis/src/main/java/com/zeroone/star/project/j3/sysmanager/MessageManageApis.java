package com.zeroone.star.project.j3.sysmanager;

import com.zeroone.star.project.j3.dto.PageDto;
import com.zeroone.star.project.j3.query.NewsPageQuery;
import com.zeroone.star.project.j3.vo.NewsPageVo;
import com.zeroone.star.project.j3.vo.NewsVo;

/**
 * 系统管理-消息管理相关接口
 */

public interface MessageManageApis {

    /**
     * 根据id查询消息详情
     *
     * @return 消息详情
     */
    NewsVo getNewsById(Integer id);

    /**
     * 分页查询消息列表
     *
     * @return 消息列表
     */
    PageDto<NewsPageVo> queryNewsList(NewsPageQuery newsPageQuery);
}
