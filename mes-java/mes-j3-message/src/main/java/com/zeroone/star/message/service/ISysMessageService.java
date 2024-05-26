package com.zeroone.star.message.service;

import com.zeroone.star.message.entity.SysMessage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zeroone.star.project.dto.login.LoginDTO;
import com.zeroone.star.project.j3.dto.LogoutDTO;
import com.zeroone.star.project.j3.dto.SystemNotificationDTO;
import com.zeroone.star.project.j3.vo.LoginResultVO;
import com.zeroone.star.project.vo.ResultStatus;

/**
 * <p>
 * 消息表 服务类
 * </p>
 *
 * @author Axe
 * @since 2024-05-24
 */
public interface ISysMessageService extends IService<SysMessage> {
    LoginResultVO login(LoginDTO loginDTO);

    ResultStatus logout(LogoutDTO logoutDTO);

    ResultStatus sendNotice(SystemNotificationDTO systemNotificationDTO);

}
