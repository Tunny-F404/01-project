package com.zeroone.star.login.controller;

import com.anji.captcha.model.common.ResponseModel;
import com.anji.captcha.model.vo.CaptchaVO;
import com.anji.captcha.service.CaptchaService;
import com.zeroone.star.login.service.CurrUserInfoService;
import com.zeroone.star.login.service.IMenuService;
import com.zeroone.star.login.service.OauthService;
import com.zeroone.star.project.components.user.UserDTO;
import com.zeroone.star.project.components.user.UserHolder;
import com.zeroone.star.project.constant.AuthConstant;
import com.zeroone.star.project.dto.login.LoginDTO;
import com.zeroone.star.project.dto.login.Oauth2TokenDTO;
import com.zeroone.star.project.j1.syslogin.vo.CurrentUserInfoVO;
import com.zeroone.star.project.login.LoginApis;
import com.zeroone.star.project.vo.JsonVO;
import com.zeroone.star.project.vo.ResultStatus;
import com.zeroone.star.project.vo.login.MenuTreeVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 描述：登录接口
 * </p>
 * <p>版权：&copy;01星球</p>
 * <p>地址：01星球总部</p>
 *
 * @author 阿伟学长
 * @version 1.0.0
 */

@RestController
@RequestMapping("login")
@Api(tags = "登录系统")
@Slf4j
public class LoginController implements LoginApis {
    @Resource
    private OauthService oAuthService;
    @Resource
    private UserHolder userHolder;
    @Resource
    private CaptchaService captchaService;
    @Resource
    RedisTemplate<String, Object> redisTemplate;

    @ApiOperation(value = "授权登录")
    @PostMapping("auth-login")
    @Override
    public JsonVO<Oauth2TokenDTO> authLogin(LoginDTO loginDTO) {
        //TODO:已经实现--实现验证码验证
        //创建CaptchaVO对象，用于封装验证码验证信息
        /*CaptchaVO captchaVO = new CaptchaVO();
        // 设置验证码字符串
        captchaVO.setCaptchaVerification(loginDTO.getCode());
        // 调用验证码服务进行验证
        ResponseModel response = captchaService.verification(captchaVO);
        if (!response.isSuccess()) {
            return JsonVO.create(null,
                    ResultStatus.FAIL.getCode(),
                    response.getRepCode()+":"+response.getRepMsg());
        }*/
        //账号密码认证
        Map<String, String> params = new HashMap<>(5);
        params.put("grant_type", "password");  //授权模式
        params.put("client_id", loginDTO.getClientId());  //登录客户端ID
        params.put("client_secret", AuthConstant.CLIENT_PASSWORD);  //客户端密码
        params.put("username", loginDTO.getUsername());  //用户名
        params.put("password", loginDTO.getPassword());  //密码

//        return oAuthService.postAccessToken(params);
        //TODO:已经实现--认证成功后如何实现注销凭证（如记录凭证到内存数据库）
        JsonVO<Oauth2TokenDTO> oauth2TokenDTOJsonVO = oAuthService.postAccessToken(params);
        if (oauth2TokenDTOJsonVO.getCode() != ResultStatus.FAIL.getCode()) {
            redisTemplate.opsForValue().set(oauth2TokenDTOJsonVO.getData().getToken(), "1");
            redisTemplate.opsForValue().set(oauth2TokenDTOJsonVO.getData().getRefreshToken(), "1");
        }
        return oauth2TokenDTOJsonVO;
    }

    @ApiOperation(value = "刷新登录")
    @PostMapping("refresh-token")
    @Override
    public JsonVO<Oauth2TokenDTO> refreshToken(Oauth2TokenDTO oauth2TokenDTO) {
        //TODO:已实现--注销凭证验证
        if (Boolean.FALSE.equals(redisTemplate.hasKey(oauth2TokenDTO.getRefreshToken()))) {
            return JsonVO.create(null, ResultStatus.FAIL.getCode(), "刷新凭证无效");
        }
        Map<String, String> params = new HashMap<>(4);
        params.put("grant_type", "refresh_token");
        params.put("client_id", oauth2TokenDTO.getClientId());
        params.put("client_secret", AuthConstant.CLIENT_PASSWORD);
        params.put("refresh_token", oauth2TokenDTO.getRefreshToken());
        return oAuthService.postAccessToken(params);
    }

    @ApiOperation(value = "退出登录")
    @GetMapping("logout")
    @Override
    public JsonVO<String> logout() {
        //TODO:已实现--登出逻辑，需要配合登录逻辑实现
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (servletRequestAttributes == null) {
            return null;
        }
        HttpServletRequest request = servletRequestAttributes.getRequest();
        String token = request.getHeader("Authorization");
        if (Boolean.TRUE.equals(redisTemplate.hasKey(token))){
            redisTemplate.delete(token);
            return JsonVO.success("登出成功");
        }
        return JsonVO.fail("登录已失效");
    }


    @Resource
    CurrUserInfoService currUserInfoService;

    @ApiOperation(value = "获取当前用户")
    @GetMapping("current-user")
    @Override
    public JsonVO<CurrentUserInfoVO> getCurrUser() { //UserHolder包含当前用户ID了，所以不用传入ID
        UserDTO currentUser;
        try {
            currentUser = userHolder.getCurrentUser();
        } catch (Exception e) {
            return JsonVO.create(null, ResultStatus.FAIL.getCode(), e.getMessage());
        }
        if (currentUser == null) {
            return JsonVO.fail(null);
        } else {
            CurrentUserInfoVO currentUserInfo = currUserInfoService.getCurrentUserInfo(currentUser);
            return JsonVO.success(currentUserInfo);
        }
    }

    @Resource
    IMenuService menuService;

    @ApiOperation(value = "获取菜单")
    @GetMapping("get-menus")
    @Override
    public JsonVO<List<MenuTreeVO>> getMenus() throws Exception {
        //获取当前用户
        UserDTO currentUser = userHolder.getCurrentUser();
        //获取当前用户拥有的菜单
        List<MenuTreeVO> menus = menuService.listMenuByRoleName(currentUser.getRoles());
        return JsonVO.success(menus);
    }
}

