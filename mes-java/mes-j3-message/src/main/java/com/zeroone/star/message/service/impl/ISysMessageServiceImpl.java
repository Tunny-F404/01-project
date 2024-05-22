package com.zeroone.star.message.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zeroone.star.message.entity.SysMessage;
import com.zeroone.star.message.service.ISysMessageService;
import com.zeroone.star.project.j3.dto.SysMessageDTO;
import com.zeroone.star.message.mapper.SysMessageMapper;
import com.zeroone.star.project.vo.JsonVO;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;


@Mapper(componentModel = "spring")
interface MsMessageMapper {
    /**
     * 将 MessageDO 转换成 MessageDTO
     * 将 MessageDTO 转换成 MessageDO
     * @param sysMessage do对象
     * @return 转换后的结果
     */
    SysMessageDTO messageToMessageDTO(SysMessage sysMessage);
    SysMessage messageDTOToMessage(SysMessageDTO sysMessageDTO);
}

/**
* @author 10439
* @description 针对表【sys_message(消息表)】的数据库操作Service实现
* @createDate 2024-05-20 11:26:34
*/
@Service
public class ISysMessageServiceImpl extends ServiceImpl<SysMessageMapper, SysMessage> implements ISysMessageService {

    @Resource
    SysMessageMapper sysMessageMapper;

    @Resource
    MsMessageMapper msMessageMapper;


    /**
     * 添加消息
     * @param sysMessageDTO 消息类
     * @return
     */
    @Transactional
    @Override
    public JsonVO<String> saveMessage(SysMessageDTO sysMessageDTO) {

        // 检查是否已存在相同的消息ID
        LambdaQueryWrapper<SysMessage> queryWrapper = new LambdaQueryWrapper<>();

        queryWrapper.eq(SysMessage::getMessageId, sysMessageDTO.getMessageId());

        boolean exists = sysMessageMapper.selectCount(queryWrapper) > 0;

        // 如果消息已存在，则返回失败
        if (exists) {
            return JsonVO.fail("该条消息已存在");
        }

        try {
            // 将DTO转换为实体
            SysMessage sysMessage = msMessageMapper.messageDTOToMessage(sysMessageDTO);

            // 插入消息到数据库
            sysMessageMapper.insert(sysMessage);


            // 返回成功消息
            return JsonVO.success(null);

        } catch (Exception e) {
            // 异常处理，记录日志或其他操作
            return JsonVO.fail("创建消息失败，错误：" + e.getMessage());
        }
    }

    /**
     * 更改消息
     * @param sysMessageDTO 消息类
     * @return
     */
    @Override
    public JsonVO<String> updateMessageById(SysMessageDTO sysMessageDTO) {

        try {
            // 将DTO转换为实体
            SysMessage sysMessage = msMessageMapper.messageDTOToMessage(sysMessageDTO);

            // 使用 LambdaUpdateWrapper 来构建更新条件
            LambdaUpdateWrapper<SysMessage> updateWrapper = new LambdaUpdateWrapper<>();

            updateWrapper.eq(SysMessage::getMessageId, sysMessageDTO.getMessageId());


            // 执行更新操作
            int updatedRows = sysMessageMapper.update(sysMessage, updateWrapper);

            // 根据更新行数判断是否成功
            if (updatedRows > 0) {
                // 更新成功
                return JsonVO.success(null);

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
     * 批量删除消息
     * @param messageIdsList 消息id集合
     * @return
     */
    @Override
    public JsonVO<String> removeMessageByIds(List<Long> messageIdsList) {

        // 检查 messageIds 是否为空
        if (messageIdsList == null || messageIdsList.isEmpty()) {
            return JsonVO.fail("消息ID数组为空！");
        }

        // 使用 in 来选择所有 messageIds 中的消息
        LambdaUpdateWrapper<SysMessage> updateWrapper = new LambdaUpdateWrapper<>();

        updateWrapper.in(SysMessage::getMessageId, messageIdsList);

        updateWrapper.set(SysMessage::getDeletedFlag,"Y");


        // 执行批量删除
//        int deletedCount = sysMessageMapper.delete(queryWrapper);//真删除
        int deletedCount = sysMessageMapper.update(null,updateWrapper);//假删除

        if (deletedCount > 0) {
            return JsonVO.success("成功删除 " + deletedCount + " 条消息!");
        } else {
            return JsonVO.fail("没有找到匹配的消息进行删除！");
        }
    }

}




