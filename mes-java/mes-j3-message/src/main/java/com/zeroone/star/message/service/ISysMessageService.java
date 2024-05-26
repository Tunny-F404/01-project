package com.zeroone.star.message.service;

import com.zeroone.star.message.entity.SysMessage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zeroone.star.project.j3.dto.SysMessageDTO;
import com.zeroone.star.project.j3.dto.SysUpdateMessageDTO;
import com.zeroone.star.project.j3.query.MessageQuery;

import java.util.List;

/**
 * <p>
 * 消息表 服务类
 * </p>
 *
 * @author Axe
 * @since 2024-05-24
 */
public interface ISysMessageService extends IService<SysMessage> {


    List<Long> removeMessages(List<Long> ids);

    List<SysMessageDTO> queryMessage(MessageQuery query);

    List<Long> modifyMessage(Long id);
}
