package com.zeroone.star.sysmanagement.controller;


import cn.hutool.core.date.DateTime;
import com.zeroone.star.project.components.easyexcel.EasyExcelComponent;
import com.zeroone.star.project.vo.JsonVO;
import com.zeroone.star.sysmanagement.entity.SysOperLog;
import com.zeroone.star.sysmanagement.service.ISysOperLogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 操作日志记录 前端控制器
 * </p>
 *
 * @author lenyan
 * @since 2024-05-19
 */
@RestController
@RequestMapping("/sys/operlog")
@Api(tags = "操作日志记录")
@Validated
public class SysOperLogController {
    @Resource
    private ISysOperLogService sysOperLogService;

    @Resource
    private EasyExcelComponent excel;

    @Value("${fastdfs.nginx-servers}")
    String urlPrefix;

    List<SysOperLog> sysOperLogs;


    @PostConstruct
    public void initData() {
        sysOperLogs = new ArrayList<>() ;
        List<SysOperLog> sysOperLogs = sysOperLogService.list();

        for(int i = 0; i <= sysOperLogs.size(); i++) {
            SysOperLog sysOperLog = sysOperLogs.get(i);
            sysOperLogs.add(sysOperLog);
        }
    }


    @ApiOperation( value = "删除日志")
    @DeleteMapping("/{operIds}")
    public JsonVO<String> deleteOperLog(@PathVariable List<Long> operIds) {
        sysOperLogService.removeByIds(operIds);
        return JsonVO.success("删除成功");
    }

    @ApiOperation( value = "清空日志")
    @DeleteMapping("/clean")
    public JsonVO<String> cleanOperLog() {
        sysOperLogService.cleanOperLog();
        return JsonVO.success("清空成功");
    }

    @SneakyThrows
    @GetMapping(value = "download", produces = "application/octet-stream")
    @ApiOperation(value = "导出操作日志")
    public ResponseEntity<byte[]> downloadOperLogExcel() {



        // 构建一个输出流
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        // 导出数据到输出流
        excel.export("导出日志", out, SysOperLog.class, sysOperLogs);
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



}

