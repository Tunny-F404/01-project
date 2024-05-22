package com.zeroone.star.orgstructure.client;

import com.zeroone.star.project.vo.JsonVO;
import com.zeroone.star.project.vo.login.LoginVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author
 * @Description:
 */
@FeignClient(value = "LOGIN")
public interface LoginClient {

    @GetMapping("login/current-user")
    JsonVO<LoginVO> getCurrUser();
}
