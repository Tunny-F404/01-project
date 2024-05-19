package com.zeroone.star.project.j2.sysmanagent;


import com.zeroone.star.project.j2.sysmanagent.dto.PageDTO;
import com.zeroone.star.project.j2.sysmanagent.dto.ParameterDTO;
import com.zeroone.star.project.j2.sysmanagent.query.ParameterQuery;
import com.zeroone.star.project.vo.JsonVO;

/**
 * @author 宵夜
 * @version 1.0.0
 * @Description: TODO
 */
public interface ParameterApis {

    JsonVO<ParameterDTO> addParam(ParameterDTO parameterDTO);

    JsonVO<Integer> deleteById(Integer id);

    JsonVO<PageDTO<ParameterDTO>> queryAll(ParameterQuery parameterQuery);
}
