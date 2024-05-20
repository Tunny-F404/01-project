package com.zeroone.star.sysmanagement.service;

import com.zeroone.star.project.dto.PageDTO;
import com.zeroone.star.project.query.j4.sysmanagement.logmanagement.OperationLog.OperationLogQuery;
import com.zeroone.star.sysmanagement.entity.SysOperLog;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 操作日志记录 服务类
 * </p>
 *
 * @author lenyan
 * @since 2024-05-19
 */
public interface ISysOperLogService extends IService<SysOperLog> {
    /**
     * 新增操作日志
     *
     * @param operLog 操作日志对象
     */
    public void insertOperlog(SysOperLog operLog);

    /**
     * 查询系统操作日志集合
     *
     * @param query 操作日志对象
     * @return 操作日志集合
     */
    public PageDTO<SysOperLog> selectOperLogList(OperationLogQuery query);

    /**
     * 查询操作日志详细
     *
     * @param operId 操作ID
     * @return 操作日志对象
     */
    public SysOperLog selectOperLogById(Long operId);

    void cleanOperLog();
}
