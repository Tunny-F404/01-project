package com.zeroone.star.project.sysmanage.operlog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zeroone.star.project.sysmanage.operlog.entity.SysOperLog;

/**
 * 操作日志记录服务接口。
 * 提供操作日志的增删查等相关操作方法定义。
 * 扩展了MyBatis Plus的IService接口，用于基础的CRUD操作。
 *
 * @author lenyan
 * @since 2024-05-19
 */
public interface IOperLogService extends IService<SysOperLog> {
    /**
     * 新增操作日志
     *
     * @param operLog 操作日志对象
     */
    public void insertOperlog(SysOperLog operLog);


}
