package com.zeroone.star.project.j2.sysmanagent;

import com.zeroone.star.project.j2.sysmanagent.dto.PageDTO;
import com.zeroone.star.project.j2.sysmanagent.dto.ParameterDTO;
import com.zeroone.star.project.j2.sysmanagent.query.ParameterQuery;
import com.zeroone.star.project.vo.JsonVO;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * @author 40斤 kino
 * @version 1.0.0
 * @Description: 参数设置API
 */
public interface ParameterApis {
    // 删除配置
    JsonVO<Integer> removeParameter(List<Integer> ids);

    // 刷新缓存
    JsonVO<List<ParameterDTO>> queryParameter();

    // 导出配置
    ResponseEntity<byte[]> exportParameter();


    JsonVO<ParameterDTO> addParam(ParameterDTO parameterDTO);

    JsonVO<Integer> deleteById(Integer id);

    JsonVO<PageDTO<ParameterDTO>> queryAll(ParameterQuery parameterQuery);





}
