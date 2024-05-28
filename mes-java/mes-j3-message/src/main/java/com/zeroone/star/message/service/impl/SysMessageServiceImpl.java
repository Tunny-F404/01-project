package com.zeroone.star.message.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zeroone.star.message.entity.SysMessage;
import com.zeroone.star.message.mapper.SysMessageMapper;
import com.zeroone.star.message.service.ISysMessageService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zeroone.star.project.j3.dto.SysMessageDTO;
import com.zeroone.star.project.j3.query.MessageQuery;
import org.springframework.beans.BeanUtils;
import com.zeroone.star.project.dto.PageDTO;
import com.zeroone.star.project.j3.query.NewsPageQuery;
import com.zeroone.star.project.j3.vo.SysMessageVO;
import com.zeroone.star.project.j3.vo.UnreadMessageVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import java.util.ArrayList;
import java.util.List;

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


    @Override
    public List<Long> removeMessages(List<Long> ids) {
        List<SysMessage> updatedList = baseMapper.selectList(new QueryWrapper<>()).stream().filter(message -> ids.contains(message.getMessageId())).map(message -> {
            SysMessage sysMessage = new SysMessage();
            BeanUtils.copyProperties(message, sysMessage);
            sysMessage.setDeletedFlag("Y");
            return sysMessage;
        }).collect(Collectors.toList());
        if(list() == null) return new ArrayList<>();
        List<Long> returnIds = new ArrayList<>();
        for(SysMessage message : updatedList){
            returnIds.add(baseMapper.update(message, new QueryWrapper<SysMessage>().eq("message_id", message.getMessageId())) > 0 ? message.getMessageId() : -1L);
        }
        return returnIds;
    }

    @Override
    public List<SysMessageDTO> queryMessage(MessageQuery query) {
        List<SysMessageDTO> sysMessages;
        if (query.getMessageId() != null){
            SysMessage sysMessage = baseMapper.selectById(query.getMessageId());
            SysMessageDTO sysMessageDTO = new SysMessageDTO();
            BeanUtils.copyProperties(sysMessage, sysMessageDTO);
            sysMessages = new ArrayList<>();
            sysMessages.add(sysMessageDTO);
        } else {
            QueryWrapper<SysMessage> wrapper = getSysMessageQueryWrapper(query);
            sysMessages = baseMapper.selectList(wrapper).stream().map(message -> {
                SysMessageDTO sysMessageDTO = new SysMessageDTO();
                BeanUtils.copyProperties(message, sysMessageDTO);
                return sysMessageDTO;
            }).collect(Collectors.toList());
        }
        return sysMessages;
    }

    private QueryWrapper<SysMessage> getSysMessageQueryWrapper(MessageQuery query) {
        QueryWrapper<SysMessage> wrapper = new QueryWrapper<>();
        if(query.getStatus() != null && !query.getStatus().isEmpty()) wrapper.eq("status", query.getStatus());
        if(query.getMessageType() != null && !query.getMessageType().isEmpty()) wrapper.like("message_type", query.getMessageType());
        if(query.getMessageLevel() != null && !query.getMessageLevel().isEmpty()) wrapper.like("message_level", query.getMessageLevel());
        if(query.getSenderNick() != null && !query.getSenderNick().isEmpty()) wrapper.like("sender_nick", query.getSenderNick());
        if(query.getRecipientNick() != null && !query.getRecipientNick().isEmpty()) wrapper.like("recipient_nick", query.getRecipientNick());
        return wrapper;
    }

    @Override
    public List<Long> modifyMessage(Long id) {
        SysMessage sysMessage = baseMapper.selectById(id);
        if(sysMessage == null){
            return new ArrayList<>();
        }
        if(sysMessage.getStatus().equals("已读")){
            sysMessage.setStatus("未读");
        } else{
            sysMessage.setStatus("已读");
        }
        baseMapper.updateById(sysMessage);
        List<Long> list = new ArrayList<>();
        list.add(id);
        return list;
    }
    @Autowired
    private SysMessageMapper sysMessageMapper;

    /**
     * 获取消息通知列表（条件+分页）
     * @param newsPageQuery
     * @return
     */
    @Override
    public PageDTO<SysMessage> pageQuery(NewsPageQuery newsPageQuery) {
        // 消息类型
        String messageType = newsPageQuery.getMessageType();
        // 消息级别
        String messageLevel = newsPageQuery.getMessageLevel();
        // 发送人昵称
        String senderNick = newsPageQuery.getSenderNick();
        // 接收人昵称
        String receiverNick = newsPageQuery.getReceiverNick();
        // 状态
        String status = newsPageQuery.getStatus();
        // 当前页
        long pageIndex = newsPageQuery.getPageIndex();
        // 每页条数
        long pageSize = newsPageQuery.getPageSize();
        // 构造条件查询
        LambdaQueryWrapper<SysMessage> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        if (messageType != null) {
            lambdaQueryWrapper.eq(SysMessage::getMessageType, messageType);
        }
        if (messageLevel != null) {
            lambdaQueryWrapper.eq(SysMessage::getMessageLevel, messageLevel);
        }
        if (senderNick != null) {
            lambdaQueryWrapper.eq(SysMessage::getSenderNick, senderNick);
        }
        if (receiverNick != null) {
            lambdaQueryWrapper.eq(SysMessage::getRecipientNick, receiverNick);
        }
        if (status != null) {
            lambdaQueryWrapper.eq(SysMessage::getStatus, status);
        }
        // 开启分页查询
        Page<SysMessage> messagePage = sysMessageMapper.selectPage(new Page<>(pageIndex, pageSize), lambdaQueryWrapper);
        // 封装PageDTO对象
        PageDTO<SysMessage> pageDTO = new PageDTO<>();
        pageDTO.setPageIndex(messagePage.getCurrent());
        pageDTO.setPageSize(messagePage.getSize());
        pageDTO.setTotal(messagePage.getTotal());
        pageDTO.setPages(messagePage.getPages());
        pageDTO.setRows(messagePage.getRecords());
        return pageDTO;
    }

    /**
     * 获取最新未读消息列表 5条
     * @return
     */
    @Override
    public UnreadMessageVO getUnreadMessage() {
        // 构造查询条件
        LambdaQueryWrapper<SysMessage> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(SysMessage::getStatus, "UNREAD");
        lambdaQueryWrapper.orderByDesc(SysMessage::getCreateTime);
        lambdaQueryWrapper.last("LIMIT 5");
        List<SysMessage> sysMessages = sysMessageMapper.selectList(lambdaQueryWrapper);
        // 封装结果
        List<SysMessageVO> list = new ArrayList<>();
        for (SysMessage sysMessage : sysMessages) {
            SysMessageVO sysMessageVO = new SysMessageVO();
            BeanUtils.copyProperties(sysMessage, sysMessageVO);
            list.add(sysMessageVO);
        }
        return UnreadMessageVO.builder()
                .unreadMessage(list)
                .build();
    }
}
