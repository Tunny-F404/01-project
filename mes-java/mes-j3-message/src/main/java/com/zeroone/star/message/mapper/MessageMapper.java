package com.zeroone.star.message.mapper;

import com.zeroone.star.message.entity.Message;
import com.zeroone.star.project.j3.dto.MessageDTO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.mapstruct.Mapper;

/**
* @author 10439
* @description 针对表【sys_message(消息表)】的数据库操作Mapper
* @createDate 2024-05-20 11:26:34
* @Entity pojo.domain.SysMessage
*/

@Mapper
public interface MessageMapper extends BaseMapper<Message> {

}




