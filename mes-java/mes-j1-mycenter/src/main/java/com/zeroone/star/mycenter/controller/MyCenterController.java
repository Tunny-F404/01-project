package com.zeroone.star.mycenter.controller;
import com.zeroone.star.mycenter.service.MyCenterService;
import com.zeroone.star.project.components.fastdfs.FastDfsClientComponent;
import com.zeroone.star.project.j1.mycenter.MyCenterApis;
import com.zeroone.star.project.j1.mycenter.dto.mail.MailDTO;
import com.zeroone.star.project.j1.mycenter.dto.user.UserDTO;
import com.zeroone.star.project.vo.JsonVO;
import io.github.bluemiaomiao.service.FastdfsClientService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.zeroone.star.project.j1.mycenter.dto.MyCenterDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.time.LocalDateTime;

/**
 * @author 柱、白河夜船
 * @version 1.0.0
 * @Description: 个人中心
 * @since 2024-5-19
 */
@Slf4j
@RestController
@RequestMapping("/mycenter")
@Api("个人中心")
public class MyCenterController implements MyCenterApis {

    @Autowired
    private MyCenterService myCenterService;
    //@author 柱
    @Resource
    private FastDfsClientComponent dfs;
    @Resource
    private FastdfsClientService remoteService;
    @Override
    @PostMapping("/modify-info")
    @ApiOperation("修改个人信息")
    public JsonVO<MyCenterDTO> modifyInfo(@RequestBody MyCenterDTO myCenterDTO) {
        try{
            myCenterDTO.setUpdate_time(LocalDateTime.now());
            MyCenterDTO updateDTO = myCenterService.updateInfo(myCenterDTO);
            return JsonVO.success(updateDTO);
        }catch (Exception e){
            e.printStackTrace();
            myCenterDTO.setFail_msg("修改个人信息时发生异常");
            return JsonVO.fail(myCenterDTO);
        }

    }

    @Override
    @PostMapping("/modify-avatar")
    @ApiOperation("修改头像")
    public JsonVO<MyCenterDTO> modifyAvatar(MyCenterDTO myCenterDTO) {
        try {
            myCenterDTO.setUpdate_time(LocalDateTime.now());
            MyCenterDTO updateDTO = myCenterService.updateAvatar(myCenterDTO);
            return JsonVO.success(updateDTO);
        }catch (Exception e){
            myCenterDTO.setFail_msg("修改头像时发生错误");
            return JsonVO.fail(myCenterDTO);
        }
    }

    @Override
    @PostMapping("/modify-phone")
    @ApiOperation("修改手机")
    public JsonVO<MyCenterDTO> modifyPhone(@RequestBody MyCenterDTO myCenterDTO) {
        try{
            myCenterDTO.setUpdate_time(LocalDateTime.now());
            String pattern = "^1[0-9]{10}$";

            if(myCenterDTO.getPhonenumber() == null ||!myCenterDTO.getPhonenumber().matches(pattern)){
                myCenterDTO.setFail_msg("手机号格式不正确");
                return JsonVO.fail(myCenterDTO);
            }

            MyCenterDTO updateDTO = myCenterService.updatePhone(myCenterDTO);
            return JsonVO.success(updateDTO);
        }catch(Exception e){
            myCenterDTO.setFail_msg("修改手机时发生错误");
            return JsonVO.fail(myCenterDTO);
        }

    }

    @Override
    @PostMapping("/modify-email")
    @ApiOperation("修改邮箱")
    public JsonVO<MyCenterDTO> modifyEmail(@RequestBody MyCenterDTO myCenterDTO) {
        try{
            myCenterDTO.setUpdate_time(LocalDateTime.now());
            String pattern = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";

            if (!myCenterDTO.getEmail().matches(pattern)) {
                myCenterDTO.setFail_msg("邮箱格式不正确");
                return JsonVO.fail(myCenterDTO);
            }
            MyCenterDTO updateDTO = myCenterService.updateEmail(myCenterDTO);
            return JsonVO.success(updateDTO);
        }catch (Exception e){
            myCenterDTO.setFail_msg("修改邮箱时发生错误");
            return JsonVO.fail(myCenterDTO);
        }

    }

    @Override
    @PostMapping("/modify-password")
    @ApiOperation("修改密码")
    public JsonVO<MyCenterDTO> modifyPassword(@RequestBody MyCenterDTO myCenterDTO) {
        try {
            myCenterDTO.setUpdate_time(LocalDateTime.now());
            if (myCenterDTO.getPassword().length() < 8) {
                myCenterDTO.setFail_msg("密码长度太短");
                return JsonVO.fail(myCenterDTO);
            }
            MyCenterDTO updateDTO = myCenterService.updatePassword(myCenterDTO);
            return JsonVO.success(updateDTO);
        }catch (Exception e){
            myCenterDTO.setFail_msg("修改密码时发生错误");
            return JsonVO.fail(myCenterDTO);
        }
    }



    //@author 白河夜船
    /**
     * 获取个人信息,ThreadLocal获取登录ID
     *
     * @param userId
     */
    @Override
    @PostMapping("/get-personal-info")
    @ApiOperation("查询个人信息")
    public JsonVO<UserDTO> getPersonalInfo(Long userId) {
        UserDTO userDTO = new UserDTO();
        return JsonVO.success(userDTO);
    }

    /**
     * 获取邮箱验证码
     *
     * @param mailDto
     * @return
     */
    @Override
    @PostMapping("/get-emailCode")
    @ApiOperation("获取邮箱验证码")
    public JsonVO<Integer> getEMailCode(MailDTO mailDto) {
        return JsonVO.success(1);
    }

    /**
     * 获取手机验证码
     *
     * @param phone
     * @return
     */
    @Override
    @PostMapping("/get-phoneCode")
    @ApiOperation("获取手机验证码")
    public JsonVO<Integer> getPhoneCode(String phone) {
        return JsonVO.success(1);
    }
}