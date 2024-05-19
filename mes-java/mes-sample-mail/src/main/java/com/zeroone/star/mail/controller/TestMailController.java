package com.zeroone.star.mail.controller;

import cn.hutool.core.bean.BeanUtil;
import com.zeroone.star.project.components.mail.MailComponent;
import com.zeroone.star.project.components.mail.MailMessage;
import com.zeroone.star.project.dto.mail.MailDTO;
import com.zeroone.star.project.vo.JsonVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

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
@RequestMapping("mail")
@Api(tags = "mail")
public class TestMailController {
    @Resource
    private MailComponent mailComponent;
    
    @ApiOperation(value = "测试邮件发送")
    @PostMapping(value = "send-mail")
    public JsonVO<MailMessage> sendMail(MailDTO mailDto) {
        MailMessage msg = new MailMessage();
        BeanUtil.copyProperties(mailDto, msg);
        //发送邮件和附件
        MailMessage result = mailComponent.sendMail(msg);
        if ("ok".equals(result.getStatus())) {
            return JsonVO.success(result);
        }
        return JsonVO.fail(result);
    }
}
