package com.zeroone.star.sysmanager.controller;

import com.zeroone.star.project.j3.dto.ExportConditionMessageDTO;
import com.zeroone.star.project.j3.dto.ExportMessageDTO;
import com.zeroone.star.project.j3.dto.SysAddMessageDTO;
import com.zeroone.star.project.j3.dto.SysUpdateMessageDTO;
import com.zeroone.star.project.j3.sysmanager.MessageManageApis;
import com.zeroone.star.project.vo.JsonVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.SneakyThrows;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Api(tags = "消息管理")
@RestController
@RequestMapping("sys-manager/message-manager")
@ResponseBody
public class MessageManageController implements MessageManageApis {


    /**
     * 添加消息
     * @param sysAddMessageDTO 消息实体
     * @return
     */
    @PostMapping("add-message")
    @Override
    @ApiOperation(value = "添加消息")
    public JsonVO<String> addMessage(@RequestBody SysAddMessageDTO sysAddMessageDTO) {
        return null;

    }

    /**
     * 更改消息
     * @param sysUpdateMessageDTO 消息
     * @return
     */
    @PutMapping("modify-message")
    @Override
    @ApiOperation(value = "修改消息")
    public JsonVO<String> modifyMessage(@RequestBody SysUpdateMessageDTO sysUpdateMessageDTO) {
        return null;
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
        return null;
    }

    /**
     * 方法封装-转换@param 字符串id 为集合
     * @param messageIds 前端传入的param字符串id
     * @return 消息id 集合
     */
    public List<Long> StringIdToList(String messageIds){

        return null;
    }

    /**
     * 方法封装-转换数据到DTO
     * @param exportConditionMessageDTO 根据发送参数筛选 获取数据
     * @return 导出类型消息DTO集合
     */
    public List<ExportMessageDTO> dataConversion(ExportConditionMessageDTO exportConditionMessageDTO){

        return null;
    }

    /**
     * 全部数据导出报表
     * @return 报表
     */
    @SneakyThrows
    @GetMapping(value = "download-messageAll", produces = "application/octet-stream")
    @ApiOperation(value = "下载全部数据到Excel")
    public ResponseEntity<byte[]> downloadMessageExcelALL() {
        return null;
    }

    /**
     * 所有数据导出到dfs
     * @return 下载地址
     */
    @SneakyThrows
    @ResponseBody
    @GetMapping(value = "export-messageAll-dfs")
    @ApiOperation(value = "导出全部数据到dfs")
    public JsonVO<String> exportMessageToDfsALL() {
        return null;
    }


    /**
     * 根据指定id数据导出报表
     * @return 报表
     */
    @SneakyThrows
    @PostMapping(value = "download-message", produces = "application/octet-stream")
    @ApiOperation(value = "根据id筛选下载Excel")
    public ResponseEntity<byte[]> downloadMessageExcel(@RequestBody ExportConditionMessageDTO exportConditionMessageDTO) {
        return null;
    }

    /**
     * 根据指定id导出到 dfs
     * @return 下载地址
     */
    @SneakyThrows
    @ResponseBody
    @PostMapping(value = "export-message-dfs")
    @ApiOperation(value = "根据id筛选导出到dfs")
    public JsonVO<String> exportMessageToDfs(@RequestBody ExportConditionMessageDTO exportConditionMessageDTO) {
        return null;
    }
}
