package com.zeroone.star.project.j1.orgstructure.user;

import com.zeroone.star.project.j1.orgstructure.dto.PageDTO;
import com.zeroone.star.project.j1.orgstructure.dto.user.CompleteUserDTO;
import com.zeroone.star.project.j1.orgstructure.dto.user.UpdateUserStatusDTO;
import com.zeroone.star.project.j1.orgstructure.dto.user.UserDTO;
import com.zeroone.star.project.j1.orgstructure.query.user.UserQuery;
import com.zeroone.star.project.vo.JsonVO;

import java.util.List;

/**
 * <p>
 *     描述：用户管理接口
 * </p>
 * @author Tme
 * @version 1.0.0
 */
public interface UserApis {
    /**
     * 获取用户列表
     * @param userQuery 查询条件对象
     * @return 查询结果列表
     */
    JsonVO<List<UserDTO>> queryUserList(UserQuery userQuery);
    /**
     * 获取用户详情
     * @param userDTO 查询条件对象
     * @return 查询结果
     */
    JsonVO<CompleteUserDTO> queryUser(UserDTO userDTO);

	/**
	 * 设置用户状态
	 */
	public JsonVO setUserStatus(UpdateUserStatusDTO userDTO);

	/**
	 * 重置用户密码
	 */
	public JsonVO resetUserPassword();


/**
     * 查询角色列表
     * @param userQuery
     * @return
     */
    JsonVO<PageDTO<UserDTO>> queryRoleList(UserQuery userQuery);
    /**
     * 查询用户分配角色列表
     * @param UserName
     * @return
     */
    JsonVO<PageDTO<UserDTO>> queryUserRoleList(String UserName);
    /**
     * 添加角色
     * @param userQuery
     * @return
     */
    JsonVO<UserDTO> modifyAddRole(UserQuery userQuery);
    /**
     * 取消角色
     * @param userQuery
     * @return
     */
    JsonVO<UserDTO> modifyDeleteRole(UserQuery userQuery);
}
