package com.zeroone.star.orgstructure.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zeroone.star.orgstructure.entity.User;
import com.zeroone.star.orgstructure.entity.UserPost;
import com.zeroone.star.orgstructure.entity.UserRole;
import com.zeroone.star.orgstructure.mapper.UserMapper;
import com.zeroone.star.orgstructure.service.IUserPostService;
import com.zeroone.star.orgstructure.service.IUserRoleService;
import com.zeroone.star.orgstructure.service.IUserService;
import com.zeroone.star.project.components.user.UserHolder;
import com.zeroone.star.project.j1.orgstructure.dto.user.AddUserDTO;
import com.zeroone.star.project.j1.orgstructure.dto.user.UpdateUserDTO;

import lombok.SneakyThrows;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Resource
    private UserMapper userMapper;
    @Resource
    private IUserRoleService userRoleService;

    @Resource
    private IUserPostService userPostService;

    @Resource
    UserHolder userHolder;

    /**
     * 新增用户
     * @param addUserDTO 传入用户信息
     */
    @SneakyThrows
    public void saveUser(AddUserDTO addUserDTO){
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        User user = new  User();
        BeanUtils.copyProperties(addUserDTO, user, "postId", "roleId");
        user.setCreateTime(LocalDateTime.now());
//        UserDTO currentUser = userHolder.getCurrentUser();
//        user.setCreateBy(currentUser.getUsername());
        user.setDelFlag("0");
        this.save(user);

        queryWrapper.eq(User::getUserName, addUserDTO.getUserName());
        Long userId = userMapper.selectOne(queryWrapper).getUserId();

        List<UserPost> userPosts = new ArrayList<>();
        for (Long postId : addUserDTO.getPostId()) {
            UserPost userPost = new UserPost();
            userPost.setUserId(userId);
            userPost.setPostId(postId);
            userPosts.add(userPost);
        }
        userPostService.saveBatch(userPosts);

        List<UserRole> userRoles = new ArrayList<>();
        for (Long roleId : addUserDTO.getRoleId()) {
            UserRole userRole = new UserRole();
            userRole.setUserId(userId);
            userRole.setRoleId(roleId);
            userRoles.add(userRole);
        }
        userRoleService.saveBatch(userRoles);
    }

    /**
     * 修改用户信息
     * @param updateUserDTO 传入的待更新用户信息
     */
    @Override
    public void updateUser(UpdateUserDTO updateUserDTO) {
        User user = new  User();
        BeanUtils.copyProperties(updateUserDTO, user, "postId", "roleId");
        user.setUpdateTime(LocalDateTime.now());

        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getUserId, updateUserDTO.getUserId());
        this.update(user, queryWrapper);

        LambdaQueryWrapper<UserRole> queryWrapper1 = new LambdaQueryWrapper<>();
        queryWrapper1.eq(UserRole::getUserId, updateUserDTO.getUserId());
        userRoleService.remove(queryWrapper1);

        LambdaQueryWrapper<UserPost> queryWrapper2 = new LambdaQueryWrapper<>();
        queryWrapper2.eq(UserPost::getUserId, updateUserDTO.getUserId());
        userPostService.remove(queryWrapper2);

        List<UserPost> userPosts = new ArrayList<>();
        for (Long postId : updateUserDTO.getPostId()) {
            UserPost userPost = new UserPost();
            userPost.setUserId(updateUserDTO.getUserId());
            userPost.setPostId(postId);
            userPosts.add(userPost);
        }
        userPostService.saveBatch(userPosts);

        List<UserRole> userRoles = new ArrayList<>();
        for (Long roleId : updateUserDTO.getRoleId()) {
            UserRole userRole = new UserRole();
            userRole.setUserId(updateUserDTO.getUserId());
            userRole.setRoleId(roleId);
            userRoles.add(userRole);
        }
        userRoleService.saveBatch(userRoles);
    }

    /**
     * 删除用户信息，支持批量删除
     * @param userIds 要删除的用户id
     */
    @Override
    public void removeUser(List<Long> userIds) {
        userMapper.deleteBatchIds(userIds);

        for(Long id : userIds){
            LambdaQueryWrapper<UserRole> Wrapper1 = new LambdaQueryWrapper<>();
            Wrapper1.eq(UserRole::getUserId, id);
            userRoleService.remove(Wrapper1);

            LambdaQueryWrapper<UserPost> Wrapper2 = new LambdaQueryWrapper<>();
            Wrapper2.eq(UserPost::getUserId, id);
            userPostService.remove(Wrapper2);
        }
    }

    /**
     * 校验用户名是否唯一
     * @param name 用户名
     * @return 返回查询结果个数
     */
    @Override
    public Long checkUserNameUnique(String name) {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getUserName, name);
        return userMapper.selectCount(queryWrapper);
    }

    /**
     * 校验电话号码是否唯一
     * @param phoneNumber 电话号码
     * @return 返回查询结果个数
     */
    @Override
    public Long checkPhoneUnique(String phoneNumber) {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getPhonenumber, phoneNumber);
        return userMapper.selectCount(queryWrapper);
    }

    /**
     * 检验邮箱是否唯一
     * @param email 邮箱
     * @return 返回查询结果个数
     */
    @Override
    public Long checkEmailUnique(String email) {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getEmail, email);
        return userMapper.selectCount(queryWrapper);
    }
}
