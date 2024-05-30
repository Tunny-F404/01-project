package com.zeroone.star.project.j3.messageservice;

import com.zeroone.star.project.components.sms.aliyun.SmsResult;
import com.zeroone.star.project.dto.login.LoginDTO;
import com.zeroone.star.project.dto.mail.MailDTO;
import com.zeroone.star.project.j3.dto.LogoutDTO;
import com.zeroone.star.project.j3.dto.SystemNotificationDTO;
import com.zeroone.star.project.j3.query.SmsQuery;
import com.zeroone.star.project.vo.JsonVO;
import com.zeroone.star.project.components.mail.MailMessage;
import com.zeroone.star.project.vo.ResultStatus;
import com.zeroone.star.project.vo.login.LoginVO;

import java.util.List;

/**
 * 消息服务相关接口
 */

public interface MessageServiceApis {

    /**
     * 发送短信消息
     * @return
     */
    JsonVO<SmsResult> sendOneSms(SmsQuery smsQuery);


    /**
     * 发送邮件
     * @param mailDTO 邮件信息
     * @return
     */
    JsonVO<MailMessage> sendMail(MailDTO mailDTO);

    JsonVO<LoginVO> clientLogin(LoginDTO loginDTO);

    JsonVO<ResultStatus> clientLogout(LogoutDTO logoutDTO);

    JsonVO<ResultStatus> sendNotice(SystemNotificationDTO systemNotificationDTO);


}
