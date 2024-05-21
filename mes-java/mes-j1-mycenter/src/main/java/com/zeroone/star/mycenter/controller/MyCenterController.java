package com.zeroone.star.mycenter.controller;
import com.zeroone.star.project.j1.mycenter.MyCenterApis;
import com.zeroone.star.project.j1.mycenter.dto.mail.MailDTO;
import com.zeroone.star.project.j1.mycenter.dto.user.UserDTO;
import com.zeroone.star.project.vo.JsonVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 白河夜船、
 * @version 1.0.0
 * @Description: 个人中心
 */
@Slf4j
@RequestMapping("/mycenter")
@Api("用户个人中心")
@RestController
public class MyCenterController implements MyCenterApis {


    /**
     * 获取个人信息,ThreadLocal获取登录ID
     *
     * @param userId
     */
    @Override
    @PostMapping("/get-personal-info")
    @ApiOperation("查询个人信息")
    public JsonVO<UserDTO> getPersonalInfo(Long userId) {
        UserDTO userDTO = new UserDTO();
        return JsonVO.success(userDTO);
    }

    /**
     * 获取邮箱验证码
     *
     * @param mailDto
     * @return
     */
    @Override
    @PostMapping("/get-emailCode")
    @ApiOperation("获取邮箱验证码")
    public JsonVO<Integer> getEMailCode(MailDTO mailDto) {
           return JsonVO.success(1);
    }

    /**
     * 获取手机验证码
     *
     * @param phone
     * @return
     */
    @Override
    @PostMapping("/get-phoneCode")
    @ApiOperation("获取手机验证码")
    public JsonVO<Integer> getPhoneCode(String phone) {
        return JsonVO.success(1);
    }
}
