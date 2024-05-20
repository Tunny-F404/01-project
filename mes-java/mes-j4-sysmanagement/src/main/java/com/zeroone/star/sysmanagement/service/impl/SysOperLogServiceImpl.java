package com.zeroone.star.sysmanagement.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zeroone.star.project.dto.PageDTO;
import com.zeroone.star.project.query.j4.sysmanagement.logmanagement.OperationLog.OperationLogQuery;
import com.zeroone.star.sysmanagement.entity.SysOperLog;
import com.zeroone.star.sysmanagement.mapper.SysOperLogMapper;
import com.zeroone.star.sysmanagement.service.ISysOperLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Wrapper;
import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * 操作日志记录 服务实现类
 * </p>
 *
 * @author lenyan
 * @since 2024-05-19
 */
@Service
public class SysOperLogServiceImpl extends ServiceImpl<SysOperLogMapper, SysOperLog> implements ISysOperLogService {

    @Resource
    SysOperLogMapper sysOperLogMapper;

    @Override
    public void insertOperlog(SysOperLog operLog) {
        sysOperLogMapper.insert(operLog);
    }

    @Override
    public PageDTO<SysOperLog> selectOperLogList(OperationLogQuery query) {
        //组装查询条件
        QueryWrapper<SysOperLog> queryWrapper = new QueryWrapper<>();
        if (StringUtils.isNotBlank(query.getOperName())) {
            queryWrapper.like("oper_name", query.getOperName());
        }
        if (StringUtils.isNotBlank(query.getBusinessType())) {
            queryWrapper.eq("business_type", query.getBusinessType());
        }
        if (query.getStatus() != null) {
            queryWrapper.eq("status", query.getStatus());
        }
        if (StringUtils.isNotBlank(query.getBeginTime())) {
            queryWrapper.ge("oper_time", query.getBeginTime());
        }
        if (StringUtils.isNotBlank(query.getEndTime())) {
            queryWrapper.le("oper_time", query.getEndTime());
        }
        if (StringUtils.isNotBlank(query.getTitle())) {
            queryWrapper.like("title", query.getTitle());
        }
        if (StringUtils.isNotBlank(query.getOrderByColumn())) {
            queryWrapper.orderBy(true, "asc".equals(query.getIsAsc()), query.getOrderByColumn());
        }
        //分页查询
        Page<SysOperLog> sysOperLogPageDTO = new Page<>(query.getPageIndex(), query.getPageSize());
        Page<SysOperLog> sysOperLogPage = sysOperLogMapper.selectPage(sysOperLogPageDTO, queryWrapper);
        PageDTO<SysOperLog> resPage = PageDTO.create(sysOperLogPage);
        return resPage;
    }


    @Override
    public SysOperLog selectOperLogById(Long operId) {
        return sysOperLogMapper.selectById(operId);
    }

    @Override
    public void cleanOperLog() {
        QueryWrapper<SysOperLog> queryWrapper = new QueryWrapper<>();
        queryWrapper.le("oper_time", LocalDateTime.now());
        sysOperLogMapper.delete(queryWrapper);
    }
}
