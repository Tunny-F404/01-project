package com.zeroone.star.message.service;

import com.zeroone.star.message.entity.SysMessage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zeroone.star.project.j3.dto.SysMessageDTO;
import com.zeroone.star.project.j3.query.MessageQuery;

import java.util.List;
import com.zeroone.star.project.dto.PageDTO;
import com.zeroone.star.project.j3.query.NewsPageQuery;
import com.zeroone.star.project.j3.vo.SysMessageVO;
import com.zeroone.star.project.j3.vo.UnreadMessageVO;

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
    /**
     * 获取消息通知列表（条件＋分页）
     * @param newsPageQuery
     * @return
     */
    PageDTO<SysMessage> pageQuery(NewsPageQuery newsPageQuery);

    /**
     * 获取最新未读消息列表
     * @return
     */
    UnreadMessageVO getUnreadMessage();

}
