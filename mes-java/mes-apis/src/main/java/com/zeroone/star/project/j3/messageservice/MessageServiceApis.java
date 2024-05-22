package com.zeroone.star.project.j3.messageservice;

import com.zeroone.star.project.j3.dto.SysMessageDTO;
import com.zeroone.star.project.vo.JsonVO;
import org.springframework.http.ResponseEntity;

/**
 * 消息服务相关接口
 */

public interface MessageServiceApis {


    /**
     * 增加消息
     * @param sysMessageDTO 消息实体
     * @return 响应码
     */
    public JsonVO<String> addMessage(SysMessageDTO sysMessageDTO);

    /**
     * 修改消息
     *
     * @param sysMessageDTO 消息
     * @return 结果
     */
    public JsonVO<String> modifyMessage(SysMessageDTO sysMessageDTO);

    /**
     * 批量删除消息
     *
     * @param messageIds 需要删除的消息主键集合
     * @return 结果
     */
    public JsonVO<String> removeMessageByMessageIds(String messageIds);

    /**
     * 导出消息
     * @param group 服务器分组
     * @param storageId 对应存储id
     * @return 下载文件
     */
    public ResponseEntity<byte[]> downloadMessage(String group, String storageId);

    /**
     * 下载导出Excel
     * @return 报表
     */
    public ResponseEntity<byte[]> downloadMessageExcel();


    /**
     * 导出到dfs
     * @return dfs连接
     */
    public JsonVO<String> exportMessageToDfs();
}
