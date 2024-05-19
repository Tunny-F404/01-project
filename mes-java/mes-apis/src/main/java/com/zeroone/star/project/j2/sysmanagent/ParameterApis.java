package com.zeroone.star.project.j2.sysmanagent;

import com.zeroone.star.project.j2.sysmanagent.dto.ParameterDTO;
import com.zeroone.star.project.vo.JsonVO;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * @author 40斤
 * @version 1.0.0
 * @Description: 配置参数的 删除 刷新  excel导出
 */
public interface ParameterApis {
    // 删除配置
    JsonVO<Integer> removeParameter(List<Integer> ids);

    // 刷新缓存
    JsonVO<List<ParameterDTO>> queryParameter();

    // 导出配置
    ResponseEntity<byte[]> exportParameter();





}
