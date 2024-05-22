package com.zeroone.star.sysmanagement.mapstruct;


import com.zeroone.star.project.j2.sysmanagement.dto.param.ParameterDTO;
import com.zeroone.star.sysmanagement.entity.parameterDO;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @Author: 40斤
 * @CreateTime: 2024-05-22  23:29
 * @Description: TODO
 * @Version: 1.0
 */
@Mapper(componentModel = "spring")
public interface parameterMapstruct {
    public List<ParameterDTO> DOs2DTOs(List<parameterDO> parameterDOs);
}
