package com.zeroone.star.message.service.impl;

import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.client.config.NacosConfigService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zeroone.star.message.config.NacosConfigUtil;
import com.zeroone.star.message.entity.SysMessage;
import com.zeroone.star.message.mapper.SysMessageMapper;
import com.zeroone.star.message.service.ISysMessageService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zeroone.star.project.components.sms.aliyun.SmsComponent;
import com.zeroone.star.project.components.sms.aliyun.SmsResult;
import com.zeroone.star.project.dto.PageDTO;
import com.zeroone.star.project.j3.query.NewsPageQuery;
import com.zeroone.star.project.j3.query.SmsQuery;
import com.zeroone.star.project.j3.vo.SysMessageVO;
import com.zeroone.star.project.j3.vo.UnreadMessageVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

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
    @Resource
    private SmsComponent smsComponent;

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

    @Value("${nacos.addr}")
    private String nacosServerAddr;

    /**
     * 发送短信消息
     * @param smsQuery
     * @return
     */
    @Override
    public SmsResult sendSms(SmsQuery smsQuery) {
        String phone = smsQuery.getPhone();
        String code = smsQuery.getCode();
        String mesType = smsQuery.getMesType();
        NacosConfigUtil nacosConfigUtil = null;
        try {
            nacosConfigUtil = new NacosConfigUtil(nacosServerAddr);
            String signName = nacosConfigUtil.getConfig(mesType + ".signName", "DEFAULT_GROUP", 5000);
            String templateCode = nacosConfigUtil.getConfig(mesType + ".templateCode", "DEFAULT_GROUP", 5000);
            Map<String, String> params = new HashMap<>();
            params.put("code", code);
            return smsComponent.sendSms(phone, signName, templateCode, params);
        } catch (NacosException e) {
            throw new RuntimeException(e);
        }
    }
}
