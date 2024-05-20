package com.zeroone.star.project.j1.mycenter;

import com.zeroone.star.project.j1.mycenter.dto.mail.MailDTO;
import com.zeroone.star.project.j1.mycenter.dto.mail.MailMessage;
import com.zeroone.star.project.j1.mycenter.dto.user.UserDTO;
import com.zeroone.star.project.vo.JsonVO;
import io.swagger.annotations.ApiOperation;

public interface MyCenterApis {

    /**
     * 获取个人信息,ThreadLocal获取登录ID
     */
    JsonVO<UserDTO> getPersonalInfo(Long userId);

    /**
     * 获取邮箱验证码
     * @param mailDto
     * @return
     */
    JsonVO<Integer> getEMailCode(MailDTO mailDto);

    /**
     * 获取手机验证码
     * @return
     */
    JsonVO<Integer> getPhoneCode(String phone);

}
