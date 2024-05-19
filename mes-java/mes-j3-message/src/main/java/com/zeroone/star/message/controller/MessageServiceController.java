package com.zeroone.star.message.controller;

import com.zeroone.star.project.components.fastdfs.FastDfsClientComponent;
import com.zeroone.star.project.j3.dto.MessageDTO;
import com.zeroone.star.project.j3.messageservice.MessageServiceApis;
import com.zeroone.star.project.vo.JsonVO;
import io.github.bluemiaomiao.service.FastdfsClientService;
import org.springframework.http.ResponseEntity;

import javax.annotation.Resource;

public class MessageServiceController implements MessageServiceApis {

    @Resource
    FastDfsClientComponent dfs;

    /**
     * 添加消息
     * @param messageDTO 消息实体
     * @return
     */
    @Override
    public JsonVO<MessageDTO> addMessage(MessageDTO messageDTO) {
        return null;
    }

    /**
     * 更改消息
     * @param messageDTO 消息
     * @return
     */
    @Override
    public JsonVO<MessageDTO> modifyMessage(MessageDTO messageDTO) {
        return null;
    }

    /**
     * 批量删除消息
     * @param messageIds 需要删除的消息主键集合
     * @return
     */
    @Override
    public JsonVO<MessageDTO> removeMessageByMessageIds(Long[] messageIds) {
        return null;
    }

    @Override
    public ResponseEntity<byte[]> downloadMessage(String group, String storageId) {
        return null;
    }

}
