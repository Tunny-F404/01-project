package com.zeroone.star.sysmanagement.service.impl;

import com.zeroone.star.project.j2.sysmanagement.dto.param.ParameterDTO;
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
}
