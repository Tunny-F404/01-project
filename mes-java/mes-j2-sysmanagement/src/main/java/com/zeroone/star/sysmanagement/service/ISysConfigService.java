package com.zeroone.star.sysmanagement.service;

import com.zeroone.star.sysmanagement.entity.parameterDO;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * <p>
 * 参数配置表 服务类
 * </p>
 *
 * @author sishijin
 * @since 2024-05-22
 */
public interface ISysConfigService extends IService<parameterDO> {

    /**
     * @description: 刷新缓存
     * @author: 40斤
     * @date: 2024/5/22 22:29
     * @param: []
     **/
    void refreshCache();

    /**
     * @description: 批量删除参数
     * @author: 40斤
     * @date: 2024/5/22 22:29
     * @param: [ids]
     **/
    void removeParameterList(List<Integer> ids);

    /**
     * @description: 导出参数（excel表）
     * @author: 40斤
     * @date: 2024/5/22 22:29
     * @param: []
     **/
    ResponseEntity<byte[]> exportParameter();

}
