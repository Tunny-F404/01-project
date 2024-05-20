package com.zeroone.star.sysmanagement.mapper;

import com.zeroone.star.sysmanagement.entity.SysOperLog;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 操作日志记录 Mapper 接口
 * </p>
 *
 * @author lenyan
 * @since 2024-05-19
 */
@Mapper
public interface SysOperLogMapper extends BaseMapper<SysOperLog> {

    List<SysOperLog> selectOperLogInfo();
}
