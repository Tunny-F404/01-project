package com.zeroone.star.project.j3.messageservice;

import com.zeroone.star.project.j3.dto.MessageDTO;
import com.zeroone.star.project.vo.JsonVO;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * 消息服务相关接口
 */

public interface MessageServiceApis {


    /**
     * 增加消息
     * @param messageDTO 消息实体
     * @return 响应码
     */
    public JsonVO<MessageDTO> addMessage(MessageDTO messageDTO);

    /**
     * 修改消息
     *
     * @param messageDTO 消息
     * @return 结果
     */
    public JsonVO<MessageDTO> modifyMessage(MessageDTO messageDTO);

    /**
     * 批量删除消息
     *
     * @param messageIds 需要删除的消息主键集合
     * @return 结果
     */
    public JsonVO<MessageDTO> removeMessageByMessageIds(Long[] messageIds);

    /**
     * 导出消息
     * @param group 服务器分组
     * @param storageId 对应存储id
     * @return
     */
    public ResponseEntity<byte[]> downloadMessage(String group, String storageId);

    /**
     * 下载导出Excel
     * @return
     */
    public ResponseEntity<byte[]> downloadMessageExcel();


}
