package com.zeroone.star.sample.controller;

import cn.hutool.core.date.DateTime;
import com.zeroone.star.project.components.fastdfs.FastDfsClientComponent;
import com.zeroone.star.project.components.fastdfs.FastDfsFileInfo;
import com.zeroone.star.project.vo.JsonVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

/**
 * <p>
 * 描述：文件上传下载演示控制器
 * </p>
 * <p>版权：&copy;01星球</p>
 * <p>地址：01星球总部</p>
 * @author 阿伟学长
 * @version 1.0.0
 */
@Controller
@RequestMapping("file")
@Api(tags = "文件操作")
public class FileController {
    @Resource
    FastDfsClientComponent dfs;

    @Value("${fastdfs.nginx-servers}")
    String urlPrefix;

    @SneakyThrows
    @ResponseBody
    @PostMapping("upload")
    @ApiOperation(value = "上传文件")
    public JsonVO<String> uploadFile(MultipartFile file) {
        // 获取文件后缀名
        String filename = file.getOriginalFilename();
        assert filename != null;
        String suffix = filename.substring(filename.lastIndexOf(".") + 1);
        // 上传文件到文件服务器
        FastDfsFileInfo result = dfs.uploadFile(file.getBytes(), suffix);
        if (result != null) {
            return JsonVO.success(dfs.fetchUrl(result, "http://" + urlPrefix, true));
        }
        return JsonVO.fail(null);
    }

    @SneakyThrows
    @GetMapping(value = "download", produces = "image/jpeg")
    @ApiOperation(value = "下载文件")
    public ResponseEntity<byte[]> downloadFile(String group, String storageId) {
        // 下载文件
        byte[] bytes = dfs.downloadFile(FastDfsFileInfo.builder().group(group).storageId(storageId).build());
        // 构建响应头
        HttpHeaders headers = new HttpHeaders();
        String filename = "img-" + DateTime.now().toString("yyyyMMddHHmmssS") + ".jpg";
        headers.setContentDispositionFormData("attachment", filename);
        headers.setContentType(MediaType.IMAGE_JPEG);
        // 响应文件给客户端
        return new ResponseEntity<>(bytes, headers, HttpStatus.CREATED);
    }

    @SneakyThrows
    @ResponseBody
    @DeleteMapping("delete")
    @ApiOperation(value = "删除文件")
    public JsonVO<Integer> deleteFile(String group, String storageId) {
        int result = dfs.deleteFile(FastDfsFileInfo.builder().group(group).storageId(storageId).build());
        if (result == 0) {
            return JsonVO.success(result);
        }
        return JsonVO.fail(result);
    }
}
