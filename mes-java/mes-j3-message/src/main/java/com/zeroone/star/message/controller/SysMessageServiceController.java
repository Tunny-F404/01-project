package com.zeroone.star.message.controller;

import cn.hutool.core.date.DateTime;
import com.alibaba.excel.EasyExcel;

import com.zeroone.star.message.entity.SysMessage;
import com.zeroone.star.message.service.ISysMessageService;
import com.zeroone.star.project.components.easyexcel.EasyExcelComponent;
import com.zeroone.star.project.components.fastdfs.FastDfsClientComponent;
import com.zeroone.star.project.components.fastdfs.FastDfsFileInfo;
import com.zeroone.star.project.j3.dto.ExportMessageDTO;
import com.zeroone.star.project.j3.dto.SysMessageDTO;
import com.zeroone.star.project.j3.messageservice.MessageServiceApis;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import com.zeroone.star.project.vo.JsonVO;

import io.swagger.annotations.ApiOperation;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.io.ByteArrayOutputStream;
import java.util.stream.Collectors;


@Api(tags = "消息服务")
@RequestMapping("/message-service")
@RestController
@ResponseBody
public class SysMessageServiceController implements MessageServiceApis {
    @Resource
    EasyExcelComponent excel;

    @Resource
    FastDfsClientComponent dfs;

    @Value("${fastdfs.nginx-servers}")
    String urlPrefix;

    @Resource
    ISysMessageService ISysMessageService;



    /**
     * 添加消息
     * @param sysMessageDTO 消息实体
     * @return
     */
    @PostMapping("add-message")
    @Override
    @ApiOperation(value = "添加消息")
    public JsonVO<String> addMessage(@RequestBody SysMessageDTO sysMessageDTO) {
        return ISysMessageService.saveMessage(sysMessageDTO);

    }

    /**
     * 更改消息
     * @param sysMessageDTO 消息
     * @return
     */
    @PutMapping("modify-message")
    @Override
    @ApiOperation(value = "修改消息")
    public JsonVO<String> modifyMessage(@RequestBody SysMessageDTO sysMessageDTO) {
        return ISysMessageService.updateMessageById(sysMessageDTO);
    }

    /**
     * 批量删除消息(假删除)
     * @param messageIds 需要删除的消息主键集合
     * @return
     */
    @DeleteMapping("remove-by-messageIds")
    @Override
    @ApiOperation(value = "删除消息根据id")
    public JsonVO<String> removeMessageByMessageIds(@RequestParam String messageIds) {

        List<Long> messageIdsList = new ArrayList<>();

        String[] strs = messageIds.split(",");
        for (String str:strs){
            messageIdsList.add(Long.parseLong(str));
        }

        return ISysMessageService.removeMessageByIds(messageIdsList);
    }


    /**
     * 导出报表
     * @return 报表
     */
    @SneakyThrows
    @GetMapping(value = "download-message", produces = "application/octet-stream")
    @ApiOperation(value = "下载Excel")
    public ResponseEntity<byte[]> downloadMessageExcel() {
        // 构建一个输出流
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        // 导出数据到输出流
        List<SysMessage> messages = ISysMessageService.getBaseMapper().selectList(null);

        // 转换数据到 DTO
        List<ExportMessageDTO> exportList = messages.stream().map(message -> {
            ExportMessageDTO dto = new ExportMessageDTO();
            dto.setMessageType(message.getMessageType());
            dto.setMessageLevel(message.getMessageLevel());
            dto.setMessageTitle(message.getMessageTitle());
            dto.setMessageContent(message.getMessageContent());
            dto.setSenderId(message.getSenderId());
            dto.setSenderName(message.getSenderName());
            dto.setSenderNick(message.getSenderNick());
            dto.setRecipientId(message.getRecipientId());
            dto.setRecipientName(message.getRecipientName());
            dto.setRecipientNick(message.getRecipientNick());
            dto.setProcessTime(message.getProcessTime());
            dto.setCallBack(message.getCallBack());
            dto.setStatus(message.getStatus());
            dto.setDeletedFlag(message.getDeletedFlag());
            return dto;
        }).collect(Collectors.toList());

        // 导出数据到输出流
        EasyExcel.write(out, ExportMessageDTO.class).sheet("导出").doWrite(exportList);
        // 获取字节数据
        byte[] bytes = out.toByteArray();
        out.close();

        // 构建响应头
        HttpHeaders headers = new HttpHeaders();
        String filename = "report-" + DateTime.now().toString("yyyyMMddHHmmssS") + ".xlsx";
        headers.setContentDispositionFormData("attachment", filename);
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        // 响应文件给客户端
        return new ResponseEntity<>(bytes, headers, HttpStatus.CREATED);
    }

    /**
     * 导出到 dfs
     * @return 下载地址
     */
        @SneakyThrows
        @ResponseBody
        @GetMapping(value = "export-message-dfs")
        @ApiOperation(value = "导出到dfs")
        public JsonVO<String> exportMessageToDfs() {
            // 构建一个输出流
            ByteArrayOutputStream out = new ByteArrayOutputStream();

            // 查询数据
            List<SysMessage> messages = ISysMessageService.getBaseMapper().selectList(null);

            // 转换数据到 DTO
            List<ExportMessageDTO> exportList = messages.stream().map(message -> {
                ExportMessageDTO dto = new ExportMessageDTO();
                dto.setMessageType(message.getMessageType());
                dto.setMessageLevel(message.getMessageLevel());
                dto.setMessageTitle(message.getMessageTitle());
                dto.setMessageContent(message.getMessageContent());
                dto.setSenderId(message.getSenderId());
                dto.setSenderName(message.getSenderName());
                dto.setSenderNick(message.getSenderNick());
                dto.setRecipientId(message.getRecipientId());
                dto.setRecipientName(message.getRecipientName());
                dto.setRecipientNick(message.getRecipientNick());
                dto.setProcessTime(message.getProcessTime());
                dto.setCallBack(message.getCallBack());
                dto.setStatus(message.getStatus());
                dto.setDeletedFlag(message.getDeletedFlag());
                return dto;
            }).collect(Collectors.toList());

            // 导出数据到输出流
            EasyExcel.write(out, ExportMessageDTO.class).sheet("导出").doWrite(exportList);

            // 获取字节数据
            byte[] bytes = out.toByteArray();
            out.close();

            // 上传文件到文件服务器
            FastDfsFileInfo result = dfs.uploadFile(bytes, ".xlsx");
            if (result != null) {
                return JsonVO.success(dfs.fetchUrl(result, "http://" + urlPrefix, true));
            }
            return JsonVO.fail(null);
        }
    }



