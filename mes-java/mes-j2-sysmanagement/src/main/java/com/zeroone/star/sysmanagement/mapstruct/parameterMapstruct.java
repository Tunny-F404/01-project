package com.zeroone.star.sysmanagement.mapstruct;


import com.zeroone.star.project.j2.sysmanagement.dto.param.ParameterDTO;
import com.zeroone.star.sysmanagement.entity.parameterDO;
import org.mapstruct.BeforeMapping;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @Author: 40斤
 * @CreateTime: 2024-05-22  23:29
 * @Description: TODO ：mapstruct 实现批量DO转DTO
 * @Version: 1.0
 */
@Mapper(componentModel = "spring", uses = strToStrStrategy.class)
public interface parameterMapstruct {

    public List<ParameterDTO> DOs2DTOs(List<parameterDO> parameterDOs);

}
