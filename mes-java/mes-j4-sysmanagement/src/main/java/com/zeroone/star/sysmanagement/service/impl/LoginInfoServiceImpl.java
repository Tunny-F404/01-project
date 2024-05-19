package com.zeroone.star.sysmanagement.service.impl;

import com.zeroone.star.sysmanagement.entity.LoginInfo;
import com.zeroone.star.sysmanagement.mapper.LoginInfoMapper;
import com.zeroone.star.sysmanagement.service.LoginInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 系统访问记录 服务实现类
 * </p>
 *
 * @author jingzi
 * @since 2024-05-19
 */
@Service
public class LoginInfoServiceImpl implements LoginInfoService {

    @Resource
    private LoginInfoMapper loginInfoMapper;

    @Override
    public List<LoginInfo> selectLoginInfo(LoginInfo loginInfo) {
        return null;
    }

    @Override
    public Long deleteLoginInfo(List<Long> infoId) {
        return null;
    }

    @Override
    public void clearLoginInfo() {

    }
}
