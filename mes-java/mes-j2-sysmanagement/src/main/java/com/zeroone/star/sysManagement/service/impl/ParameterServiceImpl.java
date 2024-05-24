package com.zeroone.star.sysmanagement.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zeroone.star.project.dto.PageDTO;
import com.zeroone.star.project.j2.sysmanagement.dto.param.ParameterDTO;
import com.zeroone.star.project.j2.sysmanagement.query.param.ParameterQuery;
import com.zeroone.star.sysmanagement.entity.ParameterDO;
import com.zeroone.star.sysmanagement.mapper.ParameterMapper;
import com.zeroone.star.sysmanagement.service.ParameterService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Mapper(componentModel = "spring")
interface MsParameterMapper{

    ParameterDO paraDtoToDo(ParameterDTO parameterDTO);

    ParameterDTO paraDoToDto(ParameterDO parameterDO);
}



/**
 * <p>
 * 参数配置表 服务实现类
 * </p>
 *
 * @author kino
 * @since 2024-05-22
 */
@Service
public class ParameterServiceImpl extends ServiceImpl<ParameterMapper, ParameterDO> implements ParameterService {

    @Resource
    ParameterMapper parameterMapper;

    @Resource
    MsParameterMapper ms;

    @Override
    public Integer removeParameters(List<Integer> ids) {
        return parameterMapper.deleteBatchIds(ids);
    }

    @Override
    public Integer saveParameter(ParameterDTO parameterDTO) {
        ParameterDO parameterDO = ms.paraDtoToDo(parameterDTO);
        return parameterMapper.insert(parameterDO);
    }

    @Override
    public PageDTO listAll(ParameterQuery condition) {
        boolean name = false;
        boolean key = false;
        boolean type = false;
        boolean beginTime = false;
        boolean endTime = false;
        if (condition.getConfigName() != null && !condition.getConfigName().equals("")) name = true;
        if (condition.getConfigKey() != null && !condition.getConfigKey().equals("")) key = true;
        if (condition.getConfigType() != null && !condition.getConfigType().equals("")) type = true;
        if (condition.getBeginTime() != null && !condition.getBeginTime().equals("")) beginTime = true;
        if (condition.getEndTime() != null && !condition.getEndTime().equals("")) endTime = true;
        Page<ParameterDO> page = new Page<>(condition.getPageIndex(), condition.getPageSize());
        QueryWrapper<ParameterDO> wrapper = new QueryWrapper<>();
        wrapper.like(name, "config_name", condition.getConfigName())
                .like(key, "config_key", condition.getConfigKey())
                .eq(type, "config_type", condition.getConfigType())
                .apply(beginTime, "date_format(create_time,'%y%m%d') >= date_format({0},'%y%m%d')", condition.getBeginTime())
                .apply(endTime, "date_format(create_time,'%y%m%d') <= date_format({0},'%y%m%d')", condition.getEndTime());
        Page<ParameterDO> doPage = parameterMapper.selectPage(page, wrapper);
        PageDTO<ParameterDTO> pageDTO = PageDTO.create(doPage, src -> ms.paraDoToDto(src));
        return  pageDTO;
    }

    @Override
    public Integer updateParameter(ParameterDTO parameterDTO) {
        // TODO 键名重复判断
        Integer row = parameterMapper.updateById(ms.paraDtoToDo(parameterDTO));
        return row;
    }
}
