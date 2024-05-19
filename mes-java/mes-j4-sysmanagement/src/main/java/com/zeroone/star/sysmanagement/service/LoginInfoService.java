package com.zeroone.star.sysmanagement.service;

import com.zeroone.star.project.dto.PageDTO;
import com.zeroone.star.project.dto.j4.sysmanagement.logmanagement.LoginLog.LoginLogAddDTO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zeroone.star.sysmanagement.entity.LoginInfo;

import java.util.List;

/**
 * <p>
 * 系统访问记录 服务类
 * </p>
 *
 * @author jingzi
 * @since 2024-05-19
 */
public interface LoginInfoService{


   /**
    * 获取登录日志
    * @param loginInfo 日志实体对象
    * @return
    */
   List<LoginInfo> selectLoginInfo(LoginInfo loginInfo);


   /**
    * 删除登录日志
    * @param ids 登录日志id
    */
   Long deleteLoginInfo(List<Long> ids);

   /**
    * 清空登录日志
    */
   void clearLoginInfo();

}
