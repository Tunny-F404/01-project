package com.zeroone.star.project.j1.syslogin;

import com.zeroone.star.project.j1.syslogin.dto.SysLoginDTO;
import com.zeroone.star.project.j1.syslogin.vo.CurrentUserInfoVO;
import com.zeroone.star.project.j1.syslogin.vo.CurrentUserMenuVO;
import com.zeroone.star.project.vo.JsonVO;

import java.util.List;

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

	/**
	 * 查询当前用户菜单
	 * @param userId 用户ID
	 * @return  CurrentUserMenuQuery  类型
	 */
	public JsonVO<List<CurrentUserMenuVO>> getCurrentUserMenu(Integer userId);

	/**
	 * 查询当前用户信息
	 * @param userId 用户ID
	 * @return  CurrentUserInfoQuery类型
	 */
	public JsonVO<CurrentUserInfoVO> getCurrentUserInfo(Integer userId);
}
