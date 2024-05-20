package com.zeroone.star.message.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zeroone.star.message.entity.Message;
import com.zeroone.star.message.service.MessageService;
import com.zeroone.star.project.j3.dto.MessageDTO;
import com.zeroone.star.message.mapper.MessageMapper;
import com.zeroone.star.project.vo.JsonVO;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Mapper(componentModel = "spring")
interface MsMessageMapper {
    /**
     * 将 MessageDO 转换成 MessageDTO
     * 将 MessageDTO 转换成 MessageDO
     * @param message do对象
     * @return 转换后的结果
     */
    MessageDTO messageToMessageDTO(Message message);
    Message messageDTOToMessage(MessageDTO messageDTO);
}

/**
* @author 10439
* @description 针对表【sys_message(消息表)】的数据库操作Service实现
* @createDate 2024-05-20 11:26:34
*/
@Service
public class MessageServiceImpl extends ServiceImpl<MessageMapper, Message> implements MessageService {

    @Resource
    MessageMapper messageMapper;

    @Resource
    MsMessageMapper msMessageMapper;


    /**
     * 更改消息
     * @param messageDTO 消息类
     * @return
     */
    @Override
    public JsonVO<String> updateMessageById(MessageDTO messageDTO) {

        try {
            // 将DTO转换为实体
            Message message = msMessageMapper.messageDTOToMessage(messageDTO);

            // 使用 LambdaUpdateWrapper 来构建更新条件
            LambdaUpdateWrapper<Message> updateWrapper = new LambdaUpdateWrapper<>();

            updateWrapper.eq(Message::getMessageId, messageDTO.getMessageId());

            // 执行更新操作
            int updatedRows = messageMapper.update(message, updateWrapper);

            // 根据更新行数判断是否成功
            if (updatedRows > 0) {
                // 更新成功
                return JsonVO.success("修改成功");

            } else {

                // 没有更新任何行，意味着没有找到对应的消息
                return JsonVO.fail("更改失败,没有该行消息");

            }
        } catch (Exception e) {

            // 异常处理，记录日志或其他操作
            return JsonVO.fail("修改消息失败，错误：" + e.getMessage());
        }
    }


    /**
     * 添加消息
     * @param messageDTO 消息类
     * @return
     */
    @Override
    public JsonVO<String> saveMessage(MessageDTO messageDTO) {

        // 检查是否已存在相同的消息ID
        LambdaQueryWrapper<Message> queryWrapper = new LambdaQueryWrapper<>();

        queryWrapper.eq(Message::getMessageId, messageDTO.getMessageId());

        boolean exists = messageMapper.selectCount(queryWrapper) > 0;

        // 如果消息已存在，则返回失败
        if (exists) {
            return JsonVO.fail("创建失败,已有对应消息");
        }

        try {
            // 将DTO转换为实体
            Message message = msMessageMapper.messageDTOToMessage(messageDTO);

            // 插入消息到数据库
            messageMapper.insert(message);

            // 返回成功消息
            return JsonVO.success("创建成功");

        } catch (Exception e) {
            // 异常处理，记录日志或其他操作
            return JsonVO.fail("创建消息失败，错误：" + e.getMessage());
        }
    }

    /**
     * 批量删除消息
     * @param messageIds 消息id数组
     * @return
     */
    @Override

    public JsonVO<String> removeMessageByIds(Long... messageIds) {

        // 检查 messageIds 是否为空
        if (messageIds == null || messageIds.length == 0) {
            return JsonVO.fail("消息ID数组为空！");
        }

        // 使用 in 来选择所有 messageIds 中的消息
        LambdaQueryWrapper<Message> queryWrapper = new LambdaQueryWrapper<>();

        queryWrapper.in(Message::getMessageId, messageIds);

        // 执行批量删除
        int deletedCount = messageMapper.delete(queryWrapper);

        if (deletedCount > 0) {
            return JsonVO.success("成功删除 " + deletedCount + " 条消息!");
        } else {
            return JsonVO.fail("没有找到匹配的消息进行删除！");
        }
    }


}




