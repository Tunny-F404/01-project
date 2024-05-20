package com.zeroone.star.project.j1.orgstructure.user;

import com.zeroone.star.project.dto.PageDTO;
import com.zeroone.star.project.j1.orgstructure.dto.user.UserDTO;
import com.zeroone.star.project.j1.orgstructure.query.PageQuery;
import com.zeroone.star.project.j1.orgstructure.query.user.UserQuery;
import com.zeroone.star.project.vo.JsonVO;

import java.util.List;

/**
 * <p>
 *     描述：用户管理接口
 * </p>
 * @author gimigimi
 * @version 1.0.0
 */
public interface UserApis {
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
