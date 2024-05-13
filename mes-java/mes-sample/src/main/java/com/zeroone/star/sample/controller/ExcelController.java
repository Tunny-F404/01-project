package com.zeroone.star.sample.controller;

import cn.hutool.core.date.DateTime;
import com.zeroone.star.project.components.easyexcel.EasyExcelComponent;
import com.zeroone.star.project.components.fastdfs.FastDfsClientComponent;
import com.zeroone.star.project.components.fastdfs.FastDfsFileInfo;
import com.zeroone.star.project.vo.JsonVO;
import com.zeroone.star.sample.test.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 描述：Excel操作
 * </p>
 * <p>版权：&copy;01星球</p>
 * <p>地址：01星球总部</p>
 * @author 阿伟学长
 * @version 1.0.0
 */
@Controller
@RequestMapping("excel")
@Api(tags = "Excel操作")
public class ExcelController {
    @Resource
    EasyExcelComponent excel;

    @Resource
    FastDfsClientComponent dfs;

    @Value("${fastdfs.nginx-servers}")
    String urlPrefix;

    /**
     * 测试数据
     */
    List<User> users;

    @PostConstruct
    public void initData() {
        users = new ArrayList<>(50);
        for (int i = 10; i <= 60; i++) {
            User user = new User();
            user.setId(i);
            user.setPhone("138456789" + i);
            user.setName("测试" + i);
            users.add(user);
        }
    }

    @SneakyThrows
    @GetMapping(value = "download", produces = "application/octet-stream")
    @ApiOperation(value = "下载Excel")
    public ResponseEntity<byte[]> downloadExcel() {
        // 构建一个输出流
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        // 导出数据到输出流
        excel.export("测试", out, User.class, users);
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

    @SneakyThrows
    @ResponseBody
    @GetMapping(value = "export-dfs")
    @ApiOperation(value = "导出到dfs")
    public JsonVO<String> exportToDfs() {
        // 构建一个输出流
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        // 导出数据到输出流
        excel.export("测试", out, User.class, users);
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
