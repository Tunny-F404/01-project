package com.zeroone.star.message.controller;

import com.zeroone.star.message.service.ISysMessageService;
import com.zeroone.star.project.components.mail.MailComponent;
import com.zeroone.star.project.components.mail.MailMessage;
import com.zeroone.star.project.components.sms.aliyun.SmsResult;
import com.zeroone.star.project.dto.login.LoginDTO;
import com.zeroone.star.project.dto.mail.MailDTO;
import com.zeroone.star.project.j3.dto.LogoutDTO;
import com.zeroone.star.project.j3.dto.SystemNotificationDTO;
import com.zeroone.star.project.j3.messageservice.MessageServiceApis;
import com.zeroone.star.project.j3.query.SmsQuery;
import com.zeroone.star.project.vo.JsonVO;
import com.zeroone.star.project.vo.ResultStatus;
import com.zeroone.star.project.vo.login.LoginVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Api(tags = "消息服务")
@RequestMapping("/message-service")
@ResponseBody
public class MessageServiceController implements MessageServiceApis {

//    @Autowired
//    private ISysMessageService iSysMessageService;
//    @Resource
//    private MailComponent mailComponent;

    /**
     * 发送短信消息
     * @return
     */
//    @PostMapping("/send-sms")
//    @ApiOperation("发送短信消息")
//    public JsonVO<SmsResult> sendOneSms(SmsQuery smsQuery) {
//        SmsResult smsResult = iSysMessageService.sendSms(smsQuery);
//        return JsonVO.success(smsResult);
//    }

    /**
     * 发送邮件消息
     * @param mailDTO 邮件信息
     * @return
     */
//    @PostMapping("/send-mail")
//    @ApiOperation("发送邮件消息")
//    public JsonVO<MailMessage> sendMail(MailDTO mailDTO) {
//        MailMessage msg = new MailMessage();
//        BeanUtils.copyProperties(mailDTO, msg);
//        MailMessage mailMessage = mailComponent.sendMail(msg);
//        return JsonVO.success(mailMessage);
//    }

    @ApiOperation("客户端登录")
    @PostMapping("/login")
    public JsonVO<LoginVO> clientLogin(@ApiParam("登录信息") @RequestBody LoginDTO loginDTO) {
        return null;
    }

    @ApiOperation("客户端退出")
    @PostMapping("/logout")
    public JsonVO<ResultStatus> clientLogout(@ApiParam("退出信息") @RequestBody LogoutDTO logoutDTO) {
        return null;
    }

    @ApiOperation("发送系统通知")
    @PostMapping("/send-notice")
    public JsonVO<ResultStatus> sendNotice(@ApiParam("系统通知消息") @RequestBody SystemNotificationDTO systemNotificationDTO) {
        return null;
    }
}



