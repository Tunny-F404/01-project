package com.zeroone.star.project.j1.orgstructure.user;

import com.zeroone.star.project.j1.orgstructure.dto.user.UpdateUserStatusDTO;
import com.zeroone.star.project.vo.JsonVO;

/**
 * <p>
 *     描述：用户管理接口
 * </p>
 * @author twelve
 * @version 1.0.0
 */
public interface UserApis {
	/**
	 * 设置用户状态
	 */
	public JsonVO setUserStatus(UpdateUserStatusDTO userDTO);

	/**
	 * 重置用户密码
	 */
	public JsonVO resetUserPassword();
}
