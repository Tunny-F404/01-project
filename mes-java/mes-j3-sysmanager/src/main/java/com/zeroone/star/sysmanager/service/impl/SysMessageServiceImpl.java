package com.zeroone.star.sysmanager.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zeroone.star.project.j3.dto.PageDTO;
import com.zeroone.star.project.j3.query.NewsPageQuery;
import com.zeroone.star.project.j3.vo.NewsPageVO;
import com.zeroone.star.project.j3.vo.NewsVO;
import com.zeroone.star.sysmanager.entity.SysMessage;
import com.zeroone.star.sysmanager.mapper.SysMessageMapper;
import com.zeroone.star.sysmanager.service.ISysMessageService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 消息表 服务实现类
 * </p>
 *
 * @author Axe
 * @since 2024-05-24
 */
@Service
public class SysMessageServiceImpl extends ServiceImpl<SysMessageMapper, SysMessage> implements ISysMessageService {

    @Autowired
    private SysMessageMapper sysMessageMapper;

    /**
     * 获取消息详情
     * @param id
     * @return
     */
    @Override
    public NewsVO getNewsById(Long id) {
        if (id == null){
            throw new RuntimeException("消息id不能为空");
        }
        //查询消息详情
        SysMessage sysMessage = sysMessageMapper.selectById(id);
        NewsVO newsVO = new NewsVO();
        //封装VO
        BeanUtils.copyProperties(sysMessage, newsVO);
        //返回结果
        return newsVO;
    }

    /**
     * 获取消息列表（分页+查询）
     * @param newsPageQuery
     * @return
     */
    @Override
    public PageDTO<NewsPageVO> queryNewsList(NewsPageQuery newsPageQuery) {
        //准备分页条件
        Page<SysMessage> page = new Page<>(newsPageQuery.getPageIndex(), newsPageQuery.getPageSize());
        //排序条件
        page.addOrder(new OrderItem("create_time", true));
        page.addOrder(new OrderItem("update_time", true));
        page.addOrder(new OrderItem("id", true));
        //准备分页条件
        Page<SysMessage> p = lambdaQuery()
                .eq(SysMessage::getMessageType, newsPageQuery.getMessageType())
                .eq(SysMessage::getMessageLevel, newsPageQuery.getMessageLevel())
                .eq(SysMessage::getStatus, newsPageQuery.getStatus())
                .like(SysMessage::getSenderNick, newsPageQuery.getSenderNick())
                .like(SysMessage::getRecipientNick, newsPageQuery.getReceiverNick())
                .page(page);

        //封装返回结果
        PageDTO<NewsPageVO> pageDTO = new PageDTO<>();
        //总条数
        pageDTO.setTotal((int) p.getTotal());
        //总页数
        pageDTO.setPageSize((int) p.getSize());
        List<SysMessage> records = p.getRecords();
        if (CollUtil.isEmpty(records)){
            pageDTO.setRows(Collections.emptyList());
            return pageDTO;
        }
        //返回数据
        //拷贝SysMessage到NewsPageVO
        List<NewsPageVO> newsPageVOS = records.stream().map(sysMessage -> {
            NewsPageVO newsPageVO = new NewsPageVO();
            BeanUtils.copyProperties(sysMessage, newsPageVO);
            return newsPageVO;
        }).collect(Collectors.toList());
        pageDTO.setRows(newsPageVOS);
        return pageDTO;
    }


}
