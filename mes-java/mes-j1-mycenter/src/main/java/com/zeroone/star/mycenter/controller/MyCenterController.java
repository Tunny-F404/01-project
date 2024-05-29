package com.zeroone.star.mycenter.controller;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.extra.mail.Mail;
import com.zeroone.star.mycenter.component.MailComponent;
import com.zeroone.star.mycenter.component.SmsComponent;
import com.zeroone.star.mycenter.service.UserService;
import com.zeroone.star.mycenter.sms.SmsResult;
import com.zeroone.star.project.j1.mycenter.MyCenterApis;
import com.zeroone.star.project.j1.mycenter.dto.mail.MailDTO;
import com.zeroone.star.project.j1.mycenter.dto.user.UserDTO;
import com.zeroone.star.project.j1.mycenter.entity.MailMessage;
import com.zeroone.star.project.vo.JsonVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zeroone.star.project.j1.mycenter.MyCenterApis;
import com.zeroone.star.project.j1.mycenter.dto.MyCenterDTO;
import com.zeroone.star.project.j1.mycenter.query.MyCenterQuery;
import com.zeroone.star.project.vo.JsonVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.json.Json;
import java.util.HashMap;

/**
 * @author 柱、白河夜船
 * @version 1.0.0
 * @Description: 个人中心
 * @since 2024-5-19
 */
@Slf4j
@RestController
@RequestMapping("/mycenter")
@Api("个人中心")
public class MyCenterController implements MyCenterApis {

    @Autowired
    private MailComponent mailComponent;
    @Autowired
    private SmsComponent smsComponent;
    @Autowired
    private UserService userService;
    @Autowired
    private RedisTemplate redisTemplate;


    //@author 柱
    @Override
    @PostMapping("/modify-info")
    @ApiOperation("修改个人信息")
    public JsonVO<MyCenterQuery> modifyInfo(MyCenterQuery myCenterQuery) {
        return JsonVO.success(myCenterQuery);
    }

    @Override
    @PostMapping("/modify-avatar")
    @ApiOperation("修改头像")
    public JsonVO<String> modifyAvatar(String PattenUrl) {
        return null;
    }

    @Override
    @PostMapping("/modify-phone")
    @ApiOperation("修改手机")
    public JsonVO<String> modifyPhone(String Phone) {
        return null;
    }

    @Override
    @PostMapping("/modify-email")
    @ApiOperation("修改邮箱")
    public JsonVO<String> modifyEmail(String Email) {
        return null;
    }

    @Override
    @PostMapping("/modify-password")
    @ApiOperation("修改密码")
    public JsonVO<String> modifyPassword(String Password) {
        return null;
    }



    //@author 白河夜船
    /**
     * 获取个人信息,从login模块获取用户信息
     *
     * @param userId
     */
    @Override
    @PostMapping("/get-personal-info")
    @ApiOperation("查询个人信息")
    public JsonVO<UserDTO> getPersonalInfo(Long userId) {
        UserDTO userDTO = userService.selectUser(userId);
        return JsonVO.success(userDTO);
    }

    /**
     * 获取邮箱验证码
     * @param mailDto
     * @return
     */
    @Override
    @PostMapping("/send-emailCode")
    @ApiOperation("获取邮箱验证码")
    public JsonVO<MailMessage> getEMailCode(MailDTO mailDto) {
        MailMessage mailMessage = new MailMessage();
        BeanUtil.copyProperties(mailDto,mailMessage);
        MailMessage mail = mailComponent.sendMail(mailMessage);
        if("ok".equals(mail.getStatus())){
            return JsonVO.success(mail);
        }
        return JsonVO.fail(mail);
    }

    /**
     * 获取手机验证码
     *
     * @param phone
     * @return
     */
    @Override
    @PostMapping("/send-phoneCode")
    @ApiOperation("获取手机验证码")
    public JsonVO<String> getPhoneCode(String phone) {
        String verifyCode = smsComponent.getVerifyCode(phone);
        HashMap<String, String> param = new HashMap<>();
        param.put("code", verifyCode);
        SmsResult smsResult = smsComponent.sendSms(phone, "零壹CRM", "SMS_466955258", param);
        if("OK".equals(smsResult.getCode())){
            return JsonVO.success(smsResult.toString());
        }
        return JsonVO.fail(smsResult.toString());
    }
}