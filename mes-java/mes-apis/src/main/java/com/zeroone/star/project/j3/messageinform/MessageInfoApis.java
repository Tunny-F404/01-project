package com.zeroone.star.project.j3.messageinform;

import com.zeroone.star.project.dto.login.LoginDTO;
import com.zeroone.star.project.j3.dto.LogoutDTO;
import com.zeroone.star.project.j3.dto.SystemNotificationDTO;
import com.zeroone.star.project.vo.JsonVO;
import com.zeroone.star.project.vo.ResultStatus;
import com.zeroone.star.project.vo.login.LoginVO;
import springfox.documentation.spring.web.json.Json;

/**
 * 消息通知相关接口
 */

public interface MessageInfoApis {
    JsonVO<LoginVO> clientLogin(LoginDTO loginDTO);

    JsonVO<ResultStatus> clientLogout(LogoutDTO logoutDTO);

    JsonVO<ResultStatus> sendNotice(SystemNotificationDTO systemNotificationDTO);
}
