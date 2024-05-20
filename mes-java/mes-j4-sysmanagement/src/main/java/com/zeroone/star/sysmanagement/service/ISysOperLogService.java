package com.zeroone.star.sysmanagement.service;

import com.zeroone.star.project.dto.PageDTO;
import com.zeroone.star.project.dto.j4.sysmanagement.logmanagement.OperationLog.OperationLogAddDTO;
import com.zeroone.star.project.query.j4.sysmanagement.logmanagement.OperationLog.OperationLogQuery;
import com.zeroone.star.project.query.sample.SampleQuery;
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

    void cleanOperLog();

    Boolean removeByOperIds(List<Long> operIds);

    List<SysOperLog> Operloginfo();



}
