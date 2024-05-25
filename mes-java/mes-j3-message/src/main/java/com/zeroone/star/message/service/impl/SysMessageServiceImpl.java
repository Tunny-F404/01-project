package com.zeroone.star.message.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zeroone.star.message.entity.SysMessage;
import com.zeroone.star.message.mapper.SysMessageMapper;
import com.zeroone.star.message.service.ISysMessageService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
    @ApiOperation("删除消息")
    public List<Long> removeMessages(List<Long> ids) {
        List<SysMessage> updatedList = baseMapper.selectList(new QueryWrapper<>()).stream().filter(message -> ids.contains(message.getMessageId())).map(message -> {
            SysMessage sysMessage = new SysMessage();
            BeanUtils.copyProperties(message, sysMessage);
            sysMessage.setDeletedFlag("Y");
            return sysMessage;
        }).collect(Collectors.toList());
        List<Long> returnIds = new ArrayList<>();
        for(SysMessage message : updatedList){
            returnIds.add(baseMapper.update(message, new QueryWrapper<SysMessage>().eq("message_id", message.getMessageId())) > 0 ? message.getMessageId() : -1L);
        }
        return returnIds;
    }
}
