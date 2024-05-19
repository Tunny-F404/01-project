package com.zeroone.star.project.j4.sysmanagement.logmanagement;

import com.zeroone.star.project.dto.PageDTO;
import com.zeroone.star.project.dto.j4.sysmanagement.logmanagement.LoginLog.LoginLogAddDTO;
import com.zeroone.star.project.vo.JsonVO;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * 登录日志接口API定义
 * @author: 酌
 * @version 1.0
 */
public interface LoginLogApis {


    /**
     * 删除登录日志
     * @param ids 登录日志ID
     * @return 删除数据的编号
     */
    JsonVO<Long> removeLoginLog(List<Long> ids);


    /**
     * 清空登录日志
     * @return
     */
    JsonVO<String> clearLoginLog();


    /**
     * 导出登录日志
     * @return
     */
    ResponseEntity<byte[]> exportLoginLog();
}
