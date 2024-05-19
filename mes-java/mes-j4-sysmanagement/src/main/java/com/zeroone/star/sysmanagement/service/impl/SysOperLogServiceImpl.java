package com.zeroone.star.sysmanagement.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zeroone.star.project.dto.PageDTO;
import com.zeroone.star.project.dto.j4.sysmanagement.logmanagement.OperationLog.OperationLogAddDTO;
import com.zeroone.star.project.dto.sample.SampleDTO;
import com.zeroone.star.project.query.j4.sysmanagement.logmanagement.OperationLog.OperationLogQuery;
import com.zeroone.star.project.query.sample.SampleQuery;
import com.zeroone.star.sysmanagement.entity.SysOperLog;
import com.zeroone.star.sysmanagement.mapper.SysOperLogMapper;
import com.zeroone.star.sysmanagement.service.ISysOperLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Wrapper;
import java.time.LocalDateTime;

/**
 * <p>
 * 操作日志记录 服务实现类
 * </p>
 *
 * @author lenyan
 * @since 2024-05-19
 */

@Mapper(componentModel = "spring")
interface MsOperLogMapper {
    /**
     * 将 SampleDO 转换成 SampleDTO
     * @return 转换后的结果
     */
    OperationLogAddDTO operloagToOperlogDTO(SysOperLog sysOperLog);
}

@Service
public class SysOperLogServiceImpl extends ServiceImpl<SysOperLogMapper, SysOperLog> implements ISysOperLogService {

    @Resource
    SysOperLogMapper sysOperLogMapper;

    @Resource
    MsOperLogMapper msOperLogMapper;

    @Override
    public void cleanOperLog() {
        QueryWrapper<SysOperLog> queryWrapper = new QueryWrapper<>();
        queryWrapper.le("oper_time", LocalDateTime.now());
        sysOperLogMapper.delete(queryWrapper);
    }

    public PageDTO<OperationLogAddDTO> listAll(OperationLogQuery query) {
        // 构建分页查询对象
        Page<SysOperLog> page = new Page<>(query.getPageIndex(), query.getPageSize());
        // 构建查询条件
        QueryWrapper<SysOperLog> wrapper = new QueryWrapper<>();

        wrapper.like("title", query.getTitle())
                .like("oper_name", query.getOperName())
                .like("business_type",query.getBusinessType())
                .like("status",query.getStatus());
        if (query.getStarttime() != null && query.getEndtime() != null) {
            wrapper.between("oper_time", query.getStarttime(), query.getEndtime());
        }
        // 执行分页查询
        Page<SysOperLog> result = baseMapper.selectPage(page, wrapper);
        // 结果转换成DTO
        return PageDTO.create(result, src -> msOperLogMapper.operloagToOperlogDTO(src));
    }

}

