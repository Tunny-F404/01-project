package com.zeroone.star.sms.controller;

import com.zeroone.star.project.components.sms.aliyun.SmsComponent;
import com.zeroone.star.project.components.sms.aliyun.SmsResult;
import com.zeroone.star.project.vo.JsonVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * <p>
 * 描述：书写一个测试发送短信的控制类
 * </p>
 * <p>版权：&copy;01星球</p>
 * <p>地址：01星球总部</p>
 * @author 阿伟学长
 * @version 1.0.0
 */
@RestController
@RequestMapping("sms")
@Api(tags = "sms")
public class TestSmsController {
    @Resource
    private SmsComponent sms;

    @PostMapping("send-one")
    @ApiOperation(value = "发送单条短信")
    public JsonVO<String> sendOneSms(String phone) {
        // 测试发送单条短信
        HashMap<String, String> params = new HashMap<>();
        params.put("code", "998007");
        SmsResult smsResult = sms.sendSms(phone, "阿里云短信测试", "SMS_154950909", params);
        if ("OK".equals(smsResult.getCode())) {
            return JsonVO.success(smsResult.toString());
        }
        return JsonVO.fail(smsResult.toString());
    }

    @PostMapping("send-multiple")
    @ApiOperation(value = "发送多条短信")
    public JsonVO<String> sendMultipleSms(String[] phonesParam/*手机号码之间用,分割*/) {
        // 测试群发消息
        ArrayList<String> phones = new ArrayList<>();
        ArrayList<String> signs = new ArrayList<>();
        for (String one : phonesParam) {
            phones.add(one);
            signs.add("零壹CRM");
        }
        SmsResult smsResult = sms.sendSmsBatch(phones, signs, "SMS_463590452", new ArrayList<>());
        if ("OK".equals(smsResult.getCode())) {
            return JsonVO.success(smsResult.toString());
        }
        return JsonVO.fail(smsResult.toString());
    }
}
