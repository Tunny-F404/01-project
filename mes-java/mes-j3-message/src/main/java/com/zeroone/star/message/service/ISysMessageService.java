package com.zeroone.star.message.service;

import com.zeroone.star.message.entity.SysMessage;
import com.zeroone.star.project.j3.dto.SysMessageDTO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zeroone.star.project.vo.JsonVO;

import java.util.List;

/**
* @author 10439
* @description 针对表【sys_message(消息表)】的数据库操作Service
* @createDate 2024-05-20 11:26:34
*/
public interface ISysMessageService extends IService<SysMessage> {

    /**
     * 修改消息
     * @param sysMessageDTO 消息类
     * @return 状态码
     */
    JsonVO<String> updateMessageById(SysMessageDTO sysMessageDTO);

    /**
     * 添加消息
     * @param sysMessageDTO 消息类
     * @return 状态码
     */
    JsonVO<String> saveMessage(SysMessageDTO sysMessageDTO);

    /**
     * 批量删除消息
     * @param messageIds 消息id数组
     * @return 状态码
     */
    JsonVO<String> removeMessageByIds(List<Long> messageIdsList);


}
