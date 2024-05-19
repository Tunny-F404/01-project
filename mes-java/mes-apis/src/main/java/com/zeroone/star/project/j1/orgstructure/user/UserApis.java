package com.zeroone.star.project.j1.orgstructure.user;

import com.zeroone.star.project.j1.orgstructure.query.user.UserQuery;
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
     * 新增用户
     * @param userQuery 新增用户信息
     * @return 返回信息
     */
    JsonVO<String> addUser(UserQuery userQuery);

    /**
     * 更新用户信息
     * @param userQuery 更新用户信息
     * @return 返回信息
     */
    JsonVO<String> updateUser(UserQuery userQuery);

    /**
     * 删除用户
     * @param userIds 用户ID
     * @return 返回信息
     */
    JsonVO<String> deleteUser(Long[] userIds);
}
