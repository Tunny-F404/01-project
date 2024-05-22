package com.zeroone.star.message.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zeroone.star.message.entity.ExportMessage;
import com.zeroone.star.message.mapper.ExportMessageMapper;
import com.zeroone.star.message.service.ExportMessageService;
import com.zeroone.star.project.j3.dto.ExportMessageDTO;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Mapper(componentModel = "spring")
interface MsExportMessageMapper {
    /**
     * 将 MessageDO 转换成 MessageDTO
     * 将 MessageDTO 转换成 MessageDO
     * @param message do对象
     * @return 转换后的结果
     */
    ExportMessageDTO ExportMessageToExportMessageDTO(ExportMessage message);
    ExportMessage ExportMessageDTOToExportMessage(ExportMessageDTO exportMessageDTO);
}

/**
*   导出消息的实现服务接口
*/
@Service
public class ExportMessageServiceImpl extends ServiceImpl<ExportMessageMapper, ExportMessage> implements ExportMessageService {

    @Resource
    MsExportMessageMapper msExportMessageMapper;

    @Resource
    ExportMessageMapper exportMessageMapper;



}




