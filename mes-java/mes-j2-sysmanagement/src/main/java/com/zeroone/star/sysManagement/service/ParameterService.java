package com.zeroone.star.sysmanagement.service;

import com.zeroone.star.project.j2.sysmanagement.dto.param.ParameterDTO;
import com.zeroone.star.sysmanagement.entity.ParameterDO;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 参数配置表 服务类
 * </p>
 *
 * @author kino
 * @since 2024-05-22
 */
public interface ParameterService extends IService<ParameterDO> {

    Integer removeParameters(List<Integer> ids);

    Integer saveParameter(ParameterDTO parameterDTO);

}
