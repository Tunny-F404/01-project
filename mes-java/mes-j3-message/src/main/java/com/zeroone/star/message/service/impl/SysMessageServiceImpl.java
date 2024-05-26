package com.zeroone.star.message.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zeroone.star.message.entity.SysMessage;
import com.zeroone.star.message.mapper.SysMessageMapper;
import com.zeroone.star.message.service.ISysMessageService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zeroone.star.project.j3.dto.SysMessageDTO;
import com.zeroone.star.project.j3.query.MessageQuery;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        return null;
    }

}
