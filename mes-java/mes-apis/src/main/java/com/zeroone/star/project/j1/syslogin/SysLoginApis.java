package com.zeroone.star.project.j1.syslogin;

import com.zeroone.star.project.dto.login.LoginDTO;
import com.zeroone.star.project.dto.login.Oauth2TokenDTO;
import com.zeroone.star.project.j1.syslogin.dto.SysLoginDTO;
import com.zeroone.star.project.vo.JsonVO;

public interface SysLoginApis {
    /**
     * 退出登录
     * @return 退出结果
     */
    JsonVO<String> logout();
    /**
     * 授权登录接口
     * @param loginDTO 登录数据
     * @return 授权登录结果
     */
    JsonVO<Boolean> userLogin(SysLoginDTO loginDTO);
}
