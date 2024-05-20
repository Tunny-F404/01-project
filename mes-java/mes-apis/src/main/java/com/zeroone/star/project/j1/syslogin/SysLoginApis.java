package com.zeroone.star.project.j1.syslogin;

import com.zeroone.star.project.j1.syslogin.vo.CurrentUserInfoVO;
import com.zeroone.star.project.j1.syslogin.vo.CurrentUserMenuVO;
import com.zeroone.star.project.vo.JsonVO;

import java.util.List;

public class SysLoginApis {
	/**
	 * 查询当前用户菜单
	 * @param userId 用户ID
	 * @return  CurrentUserMenuQuery  类型
	 */
	public JsonVO<List<CurrentUserMenuVO>> getCurrentUserMenu(Integer userId){
		return null;
	}

	/**
	 * 查询当前用户信息
	 * @param userId 用户ID
	 * @return  CurrentUserInfoQuery类型
	 */
	public JsonVO<CurrentUserInfoVO> getCurrentUserInfo(Integer userId){
		return null;
	}
}
