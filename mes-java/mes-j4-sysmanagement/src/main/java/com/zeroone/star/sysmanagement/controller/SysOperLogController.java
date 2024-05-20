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


    @ApiOperation( value = "删除日志")
    @DeleteMapping("/remove-operlog/{operIds}")
    public JsonVO<String> deleteOperLog(@PathVariable List<Long> operIds) {
        Boolean result = sysOperLogService.removeByIds(operIds);
        if (!result) {
            return JsonVO.fail("日志不存在");
        }
        return JsonVO.success("删除成功");
    }

    @ApiOperation( value = "清空日志")
    @DeleteMapping("/clean-operlog")
    public JsonVO<String> cleanOperLog() {
        sysOperLogService.cleanOperLog();
        return JsonVO.success("清空成功");
    }

    @SneakyThrows
    @GetMapping(value = "export-operlog", produces = "application/octet-stream")
    @ApiOperation(value = "导出操作日志")
    public ResponseEntity<byte[]> downloadOperLogExcel() {

        List<SysOperLog> sysOperLogs = sysOperLogService.Operloginfo();

        // 构建一个输出流
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        // 导出数据到输出流
        excel.export("导出操作日志", out, SysOperLog.class, sysOperLogs);
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

//        List<LoginInfo> logList = loginInfoService.listLoginInfo();
//
//        //创建输出流
//        ByteArrayOutputStream out = new ByteArrayOutputStream();
//
//        //导出数据到输出流
//        excel.export("导出登录日志", out, LoginInfo.class, logList);
//
//        //获取字节数据
//        byte[] bytes = out.toByteArray();
//        out.close();
//
//        //构建响应头
//        HttpHeaders headers = new HttpHeaders();
//        String filename = "report" + DateTime.now().toString("yyyyMMddHHmmss") + ".xlsx";
////        headers.setContentDispositionFormData("attachment", filename);
//        headers.add("Content-Disposition", "attachment;filename=" + filename);
//        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
//
//        //响应文件给客户端
//        return new ResponseEntity<>(bytes, headers, HttpStatus.CREATED);



}

