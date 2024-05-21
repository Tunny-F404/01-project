package com.zeroone.star.message.controller;

import cn.hutool.core.date.DateTime;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.zeroone.star.message.entity.ExportMessage;
import com.zeroone.star.message.service.ExportMessageService;
import com.zeroone.star.message.service.MessageService;
import com.zeroone.star.project.components.easyexcel.EasyExcelComponent;
import com.zeroone.star.project.components.fastdfs.FastDfsClientComponent;
import com.zeroone.star.project.components.fastdfs.FastDfsFileInfo;
import com.zeroone.star.project.j3.dto.MessageDTO;
import com.zeroone.star.project.j3.messageservice.MessageServiceApis;
import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.zeroone.star.project.vo.JsonVO;

import io.swagger.annotations.ApiOperation;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.io.ByteArrayOutputStream;



@Api(tags = "消息服务")
@RequestMapping("/message-service")
@Controller
public class MessageServiceController implements MessageServiceApis {
    @Resource
    EasyExcelComponent excel;

    @Resource
    FastDfsClientComponent dfs;

    @Value("${fastdfs.nginx-servers}")
    String urlPrefix;

    @Resource
    MessageService messageService;

    @Resource
    ExportMessageService exportMessageService;

    /**
     * 添加消息
     * @param messageDTO 消息实体
     * @return
     */
    @PostMapping("add-message")
    @Override
    @ApiOperation(value = "添加消息")
    public JsonVO<String> addMessage(MessageDTO messageDTO) {
        JsonVO<String> jsonVO  = messageService.saveMessage(messageDTO);
        return jsonVO;
    }

    /**
     * 更改消息
     * @param messageDTO 消息
     * @return
     */
    @PutMapping("modify-message")
    @Override
    @ApiOperation(value = "修改消息")
    public JsonVO<String> modifyMessage(MessageDTO messageDTO) {
        JsonVO<String> jsonVO  = messageService.updateMessageById(messageDTO);
        return jsonVO;
    }

    /**
     * 批量删除消息
     * @param messageIds 需要删除的消息主键集合
     * @return
     */
    @DeleteMapping("remove-by-messageIds")
    @Override
    @ApiOperation(value = "删除消息根据id")
    public JsonVO<String> removeMessageByMessageIds(Long[] messageIds) {
        JsonVO<String> jsonVO  = messageService.removeMessageByIds(messageIds);
        return jsonVO;
    }

    /**
     * 下载文件
     * @param group 服务器分组
     * @param storageId 对应存储id
     * @return
     */
    @SneakyThrows
    @GetMapping(value = "download", produces = "excel/xlsx")
    @ApiOperation(value = "下载文件")
    public ResponseEntity<byte[]> downloadMessage(String group, String storageId) {
        // 下载文件
        byte[] bytes = dfs.downloadFile(FastDfsFileInfo.builder().group(group).storageId(storageId).build());
        // 构建响应头
        HttpHeaders headers = new HttpHeaders();
        String filename = "report-" + DateTime.now().toString("yyyyMMddHHmmssS") + ".xlsx";
        headers.setContentDispositionFormData("attachment", filename);
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        // 响应文件给客户端
        return new ResponseEntity<>(bytes, headers, HttpStatus.CREATED);
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
        LambdaQueryWrapper<ExportMessage> queryWrapper = Wrappers.lambdaQuery();

//        LambdaQueryWrapper<Message> queryWrapper = Wrappers.lambdaQuery();
//        queryWrapper.select(Message::getMessageType, Message::getMessageLevel, Message::getMessageTitle, Message::getMessageContent, Message::getSenderId, Message::getSenderName, Message::getSenderNick, Message::getRecipientId, Message::getRecipientName, Message::getRecipientNick, Message::getProcessTime, Message::getCallBack, Message::getStatus, Message::getDeletedFlag);
//        List<Message> messages = messageService.getBaseMapper().selectList(queryWrapper);

        List<ExportMessage> messages = exportMessageService.getBaseMapper().selectList(queryWrapper);

        // 导出数据到输出流
        excel.export("导出", out, ExportMessage.class, messages);
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

        //查询数据

        LambdaQueryWrapper<ExportMessage> queryWrapper = Wrappers.lambdaQuery();

//        LambdaQueryWrapper<Message> queryWrapper = Wrappers.lambdaQuery();

//        queryWrapper.select(Message::getMessageType, Message::getMessageLevel, Message::getMessageTitle, Message::getMessageContent, Message::getSenderId, Message::getSenderName, Message::getSenderNick, Message::getRecipientId, Message::getRecipientName, Message::getRecipientNick, Message::getProcessTime, Message::getCallBack, Message::getStatus, Message::getDeletedFlag);

//        List<Message> messages = messageService.getBaseMapper().selectList(queryWrapper);

        List<ExportMessage> messages = exportMessageService.getBaseMapper().selectList(queryWrapper);

        // 导出数据到输出流
        excel.export("导出", out, ExportMessage.class, messages);

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
