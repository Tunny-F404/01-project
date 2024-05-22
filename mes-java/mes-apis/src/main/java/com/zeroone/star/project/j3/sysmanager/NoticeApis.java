package com.zeroone.star.project.j3.sysmanager;

import com.zeroone.star.project.dto.login.LoginDTO;
import com.zeroone.star.project.j3.dto.LogoutDTO;
import com.zeroone.star.project.j3.dto.SystemNotificationDTO;
import com.zeroone.star.project.vo.ResultStatus;
import com.zeroone.star.project.vo.login.LoginVO;

/**
 * 系统管理-通知公告相关接口
 */

public interface NoticeApis {
    LoginVO clientLogin(LoginDTO loginDTO);

    ResultStatus clientLogout(LogoutDTO logoutDTO);

    ResultStatus sendNotice(SystemNotificationDTO systemNotificationDTO);
}
