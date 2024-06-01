package com.zeroone.star.project.sysmanage.operlog.service;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zeroone.star.project.sysmanage.operlog.entity.SysOperLog;
import com.zeroone.star.project.sysmanage.operlog.mapper.OperLogMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 操作日志记录服务实现类。
 *
 * @author lenyan
 * @since 2024-05-19
 */
@Service
public class OperLogServiceImpl extends ServiceImpl<OperLogMapper, SysOperLog> implements IOperLogService {

    @Resource
    private OperLogMapper operLogMapper;

    /**
     * 删除所有操作日志记录。
     * 根据当前时间删除所有的历史操作日志，注意：此操作不可逆，请谨慎使用。
     */
    @Override
    public void insertOperlog(SysOperLog operLog) {
        operLogMapper.insert(operLog);
    }


}
