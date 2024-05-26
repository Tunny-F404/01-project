package com.zeroone.star.message.service.impl;

import com.zeroone.star.message.entity.SysMessage;
import com.zeroone.star.message.entity.User;
import com.zeroone.star.message.mapper.SysMessageMapper;
import com.zeroone.star.message.mapper.UserMapper;
import com.zeroone.star.message.service.ISysMessageService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zeroone.star.project.dto.login.LoginDTO;
import com.zeroone.star.project.j3.dto.LogoutDTO;
import com.zeroone.star.project.j3.dto.SystemNotificationDTO;
import com.zeroone.star.project.j3.vo.LoginResultVO;
import com.zeroone.star.project.j3.vo.LoginVO;
import com.zeroone.star.project.vo.ResultStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    private UserMapper userMapper;

    @Override
    public LoginResultVO login(LoginDTO loginDTO) {
        LoginResultVO loginResultVO = new LoginResultVO();
        LoginVO loginVO = new LoginVO();
        // 获取info
        String username = loginDTO.getUsername();
        String password = loginDTO.getPassword(); // TODO 加密
        // 验证
        User user = userMapper.findByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            loginVO.setId(user.getUserId());
            loginResultVO.setResultStatus(ResultStatus.SUCCESS);
            loginResultVO.setLoginVO(loginVO);
            return loginResultVO;
        }
        // 失败
        loginResultVO.setResultStatus(ResultStatus.FAIL);
        loginResultVO.setLoginVO(loginVO);
        return loginResultVO;
    }


    @Override
    public ResultStatus logout(LogoutDTO logoutDTO) {
        return null;
    }

    @Override
    public ResultStatus sendNotice(SystemNotificationDTO systemNotificationDTO) {
        return null;
    }
}
