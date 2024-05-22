package com.zeroone.star.project.j1.orgstructure.user;

import com.zeroone.star.project.j1.orgstructure.dto.user.AddUserDTO;
import com.zeroone.star.project.j1.orgstructure.dto.user.UpdateUserDTO;
import com.zeroone.star.project.vo.JsonVO;

import java.util.List;

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
     * @param addUserDTO 新增用户信息
     * @return 返回信息
     */
    JsonVO<String> addUser(AddUserDTO addUserDTO);

    /**
     * 更新用户信息
     * @param updateUserDTO 更新用户信息
     * @return 返回信息
     */
    JsonVO<String> modifyUser(UpdateUserDTO updateUserDTO);

    /**
     * 删除用户
     * @param userIds 用户ID
     * @return 返回信息
     */
    JsonVO<String> removeUser(List<Long> userIds);
}
