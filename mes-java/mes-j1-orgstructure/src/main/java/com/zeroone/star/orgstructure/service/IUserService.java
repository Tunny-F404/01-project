package com.zeroone.star.orgstructure.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zeroone.star.orgstructure.entity.User;
import com.zeroone.star.project.j1.orgstructure.dto.user.AddUserDTO;
import com.zeroone.star.project.j1.orgstructure.dto.user.UpdateUserDTO;

import java.util.List;

public interface IUserService extends IService<User> {
    public void saveUser(AddUserDTO addUserDTO);

    public void updateUser(UpdateUserDTO updateUserDTO);

    public void removeUser(List<Long> userIds);

    public Long checkUserNameUnique(String name);

    public Long checkPhoneUnique(String phoneNumber);

    public Long checkEmailUnique(String email);
}
