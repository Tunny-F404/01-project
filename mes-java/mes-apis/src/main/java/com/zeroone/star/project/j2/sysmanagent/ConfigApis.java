package com.zeroone.star.project.j2.sysmanagent;

import com.zeroone.star.project.j2.sysmanagent.dto.ConfigDTO;
import com.zeroone.star.project.vo.JsonVO;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * @author 40斤
 * @version 1.0.0
 * @Description: 配置参数的 删除 刷新  excel导出
 */
public interface ConfigApis {
    // 删除配置
    JsonVO<Integer> removeConfig(List<Integer> ids);

    // 刷新缓存
    JsonVO<List<ConfigDTO>> queryConfig();

    // 导出配置
    ResponseEntity<byte[]> exportConfig();





}
