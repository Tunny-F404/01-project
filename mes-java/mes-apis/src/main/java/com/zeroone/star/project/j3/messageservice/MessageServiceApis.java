package com.zeroone.star.project.j3.messageservice;

import com.zeroone.star.project.j3.dto.MessageDTO;
import com.zeroone.star.project.j3.query.MessageQuery;
import com.zeroone.star.project.vo.JsonVO;

import java.util.List;

/**
 * 消息服务相关接口
 */

public interface MessageServiceApis {

    JsonVO<List<Long>> removeMessages(List<Long> ids);

    JsonVO<List<MessageDTO>> queryMessage(MessageQuery query);

    JsonVO<List<Long>> modifyMessageStatus(Long id);



}
