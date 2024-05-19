package com.zeroone.star.project.j4.sysmanagement.logmanagement;

import com.zeroone.star.project.vo.JsonVO;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * 操作日志接口API定义
 * 提供操作日志的删除、清除和下载功能
 * @author: 酌
 * @version 1.0
 */

public interface OperationLogApis {

    /**
     * 删除操作日志
     * @param operIds 需要删除的操作日志ID列表
     * @return 包含删除结果的JsonVO对象
     */
    JsonVO<String> deleteOperLog(List<Long> operIds);

    /**
     * 清除所有操作日志
     * @return 包含清除结果的JsonVO对象
     */
    JsonVO<String> cleanOperLog();

    /**
     * 下载操作日志的Excel文件
     * @return 包含操作日志数据的Excel文件的字节数组
     */

    ResponseEntity<byte[]> downloadOperLogExcel();
}
