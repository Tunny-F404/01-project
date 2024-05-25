package com.zeroone.star.sysmanager.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zeroone.star.project.j3.dto.SysAddMessageDTO;
import com.zeroone.star.project.j3.dto.SysUpdateMessageDTO;
import com.zeroone.star.project.vo.JsonVO;
import com.zeroone.star.sysmanager.entity.SysMessage;
import com.zeroone.star.sysmanager.mapper.SysMessageMapper;
import com.zeroone.star.sysmanager.service.ISysMessageService;
import org.apache.poi.ss.formula.functions.T;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;


@Mapper(componentModel = "spring")
interface MsMessageMapper {
    /**
     * 将 MessageDO 转换成 MessageDTO
     * 将 MessageDTO 转换成 MessageDO
     * @param sysMessage do对象
     * @return 转换后的结果
     */
    SysAddMessageDTO sysMessageToSysAddMessageDTO(SysMessage sysMessage);
    SysMessage sysAddMessageDTOToMessage(SysAddMessageDTO sysAddMessageDTO);

    SysUpdateMessageDTO sysMessageToSysUpdateMessageDTO(SysMessage sysMessage);
    SysMessage sysUpdateAMessageDTOToMessage(SysUpdateMessageDTO sysUpdateMessageDTO);
}

/**
 * @author 10439
 * @description 针对表【sys_message(消息表)】的数据库操作Service实现
 * @createDate 2024-05-20 11:26:34
 */
@Service
public class SysMessageServiceImpl extends ServiceImpl<SysMessageMapper, SysMessage> implements ISysMessageService {

    @Resource
    SysMessageMapper sysMessageMapper;

    @Resource
    MsMessageMapper msMessageMapper;


    /**
     * 添加消息
     * @param sysAddMessageDTO 消息类
     * @return
     */
    @Transactional
    @Override
    public JsonVO<String> saveMessage(SysAddMessageDTO sysAddMessageDTO) {

        try {
            // 将DTO转换为实体
            SysMessage sysMessage = msMessageMapper.sysAddMessageDTOToMessage(sysAddMessageDTO);

            //根据昵称获取用户信息
            String recipientNick = sysMessage.getRecipientNick();
            LambdaQueryWrapper userQuery = new LambdaQueryWrapper();
            //查询用户信息添加到数据库中

            //额外增加四条属性 id，状态,是否删除,创建时间

            //查询最后一条数据id
            LambdaQueryWrapper<SysMessage> queryWrapper = new LambdaQueryWrapper<>();
            //id倒叙搜索 限制获取最后一条数据
            queryWrapper.orderByDesc(SysMessage::getMessageId).last("LIMIT 1");
            //获得数据id
            Long messageId = sysMessageMapper.selectOne(queryWrapper).getMessageId();

            //插入 id,状态、是否删除、创建时间 字段
            sysMessage.setMessageId(messageId + 1);
            sysMessage.setStatus("未读");
            sysMessage.setDeletedFlag("N");
            sysMessage.setCreateTime(LocalDateTime.now());

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
     * @param sysUpdateMessageDTO 消息类
     * @return
     */
    @Override
    public JsonVO<String> updateMessageById(SysUpdateMessageDTO sysUpdateMessageDTO) {

        try {
            // 将DTO转换为实体
            SysMessage sysMessage = msMessageMapper.sysUpdateAMessageDTOToMessage(sysUpdateMessageDTO);

            // 使用 LambdaUpdateWrapper 来构建更新条件
            LambdaUpdateWrapper<SysMessage> updateWrapper = new LambdaUpdateWrapper<>();

            updateWrapper.eq(SysMessage::getMessageId, sysUpdateMessageDTO.getMessageId());

            //根据昵称查询用户对应信息
//            LambdaQueryWrapper<?> queryWrapper = new LambdaQueryWrapper();
//            queryWrapper.eq(::,sysMessage.getRecipientNick());
//            xxx.mapper.selectList;
//            sysMessage.setRecipientId();

            //添加 更改时间
            sysMessage.setUpdateTime(LocalDateTime.now());

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




