package com.zeroone.star.message.service;

import com.alibaba.nacos.api.exception.NacosException;
import com.zeroone.star.message.entity.SysMessage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zeroone.star.project.components.sms.aliyun.SmsResult;
import com.zeroone.star.project.dto.PageDTO;
import com.zeroone.star.project.j3.query.NewsPageQuery;
import com.zeroone.star.project.j3.query.SmsQuery;
import com.zeroone.star.project.j3.vo.SysMessageVO;
import com.zeroone.star.project.j3.vo.UnreadMessageVO;

/**
 * <p>
 * 消息表 服务类
 * </p>
 *
 * @author Axe
 * @since 2024-05-24
 */
public interface ISysMessageService extends IService<SysMessage> {

    /**
     * 获取消息通知列表（条件＋分页）
     * @param newsPageQuery
     * @return
     */
    PageDTO<SysMessage> pageQuery(NewsPageQuery newsPageQuery);

    /**
     * 获取最新未读消息列表
     * @return
     */
    UnreadMessageVO getUnreadMessage();

    /**
     * 发送短信消息
     * @param smsQuery
     * @return
     */
    SmsResult sendSms(SmsQuery smsQuery);
}
