package com.zeroone.star.sysmanagement.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zeroone.star.sysmanagement.entity.SysOperLog;
import com.zeroone.star.sysmanagement.mapper.SysOperLogMapper;
import com.zeroone.star.sysmanagement.service.ISysOperLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 操作日志记录服务实现类。
 * 实现了{@link ISysOperLogService}接口，提供了操作日志的增删改查等功能的具体实现。
 * 基于MyBatis Plus的{@link ServiceImpl}简化 CRUD 操作的实现。
 *
 * @author lenyan
 * @since 2024-05-19
 */
@Service
public class SysOperLogServiceImpl extends ServiceImpl<SysOperLogMapper, SysOperLog> implements ISysOperLogService {

    @Resource
    private SysOperLogMapper sysOperLogMapper;

    /**
     * 删除所有操作日志记录。
     * 根据当前时间删除所有的历史操作日志，注意：此操作不可逆，请谨慎使用。
     */
    @Override
    public void removeAllOperLog() {
        QueryWrapper<SysOperLog> queryWrapper = new QueryWrapper<>();
        queryWrapper.le("oper_time", LocalDateTime.now()); // 假设 oper_time 字段表示操作时间，删除时间小于等于当前时间的记录
        sysOperLogMapper.delete(queryWrapper);
    }

    /**
     * 查询操作日志信息。
     *
     * @return 操作日志实体列表
     */
    @Override
    public List<SysOperLog> Operloginfo() {
        return sysOperLogMapper.selectOperLogInfo();
    }
}