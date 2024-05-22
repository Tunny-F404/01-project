package com.zeroone.star.orgstructure.controller;

import com.alibaba.cloud.commons.lang.StringUtils;
import com.zeroone.star.orgstructure.service.IUserService;
import com.zeroone.star.project.j1.orgstructure.dto.user.AddUserDTO;
import com.zeroone.star.project.j1.orgstructure.dto.user.UpdateUserDTO;
import com.zeroone.star.project.j1.orgstructure.user.UserApis;
import com.zeroone.star.project.vo.JsonVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("user")
@Api(tags = "用户管理")
public class UserController implements UserApis {

    @Resource
    private IUserService userService;

    @PostMapping("add-user")
    @ApiOperation(value = "新增用户")
    @Override
    public JsonVO<String> addUser(@RequestBody AddUserDTO addUserDTO) {
        if (userService.checkUserNameUnique(null, addUserDTO.getUserName()) > 0)
        {
            return JsonVO.fail("新增用户失败，登录账号已存在");
        }
        else if (StringUtils.isNotEmpty(addUserDTO.getPhonenumber())
                && userService.checkPhoneUnique(null, addUserDTO.getPhonenumber()) > 0)
        {
            return JsonVO.fail("新增用户失败，手机号码已存在");
        }
        else if (StringUtils.isNotEmpty(addUserDTO.getEmail())
                && userService.checkEmailUnique(null, addUserDTO.getEmail()) > 0)
        {
            return JsonVO.fail("新增用户失败，邮箱账号已存在");
        }
//        addUserDTO.setCreateBy(getUsername());
//        addUserDTO.setPassword(SecurityUtils.encryptPassword(addUserDTO.getPassword()));
        userService.saveUser(addUserDTO);
        return JsonVO.success("新增用户成功");
    }

    @PutMapping("modify-user")
    @ApiOperation(value = "修改用户")
    @Override
    public JsonVO<String> modifyUser(@RequestBody UpdateUserDTO updateUserDTO) {
        if (StringUtils.isNotEmpty(updateUserDTO.getPhonenumber())
                && userService.checkPhoneUnique(updateUserDTO.getUserId(), updateUserDTO.getPhonenumber()) > 0)
        {
            return JsonVO.fail("修改用户失败，手机号码已存在");
        }
        else if (StringUtils.isNotEmpty(updateUserDTO.getEmail())
                && userService.checkEmailUnique(updateUserDTO.getUserId(), updateUserDTO.getEmail()) > 0)
        {
            return JsonVO.fail("修改用户失败，邮箱账号已存在");
        }
        userService.updateUser(updateUserDTO);
        return JsonVO.success("修改用户信息成功");
    }

    @DeleteMapping("remove-user")
    @ApiOperation(value = "删除用户")
    @Override
    public JsonVO<String> removeUser(@RequestParam List<Long> userIds) {
        userService.removeUser(userIds);
        return JsonVO.success("删除成功");
    }
}
