package com.zeroone.star.project.j1.syslogin.Captcha;

public interface LoginCaptcha {
    /**
     * 获取验证码
     * @return 验证码
     */
    int getCaptcha();
    /**
     * 验证验证码
     * @return 验证码是否正确的结果
     */
    boolean isCaptcha();
}
