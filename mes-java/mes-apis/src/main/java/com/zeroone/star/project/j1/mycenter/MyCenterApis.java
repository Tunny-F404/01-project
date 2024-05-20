package com.zeroone.star.project.j1.mycenter;

import com.zeroone.star.project.j1.mycenter.dto.MyCenterDTO;
import com.zeroone.star.project.vo.JsonVO;

/**
 * @author 柱
 * @version 1.0.0
 * @Description MyCenterApis
 */
public interface MyCenterApis {

    //修改个人信息
    JsonVO<MyCenterDTO> modifyInfo(MyCenterDTO myCenterDTO);
    //修改头像
    JsonVO<String> modifyAvatar(String PattenUrl);
    //修改手机
    JsonVO<String> modifyPhone(String Phone);
    //修改邮箱
    JsonVO<String> modifyEmail(String Email);
    //修改密码
    JsonVO<String> modifyPassword(String Password);
}
