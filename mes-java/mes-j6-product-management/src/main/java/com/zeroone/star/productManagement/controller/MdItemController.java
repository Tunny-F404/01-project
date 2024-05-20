package com.zeroone.star.productManagement.controller;

import com.zeroone.star.project.components.easyexcel.EasyExcelComponent;
import com.zeroone.star.project.components.fastdfs.FastDfsClientComponent;
import com.zeroone.star.project.components.sms.aliyun.SmsResult;
import com.zeroone.star.project.j6.product_management.MdItemApis;
import com.zeroone.star.project.j6.product_management.query.MdItemQuery;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.SneakyThrows;
import org.apache.tomcat.util.http.fileupload.ByteArrayOutputStream;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

@Controller
@Api(tags = "product-management")
@RequestMapping("/mes/md/mditem")
public class MdItemController implements MdItemApis {
    @Resource
    EasyExcelComponent excel;
    @Resource
    FastDfsClientComponent dfs;
    //导出产品列表
    @SneakyThrows
    @PostMapping(value = "/export")
    @ApiOperation(value = "导出物料产品列表")
    public ResponseEntity<byte[]> exportToExcel(MdItemQuery mdItemQuery){
        return null;
    }
    //下载导入模板
    @SneakyThrows
    @PostMapping(value = "/importTemplate")
    @ApiOperation(value = "下载模板")
    public ResponseEntity<byte[]> importTemplate() {
        return null;
    }
    //导入产品数据
    @SneakyThrows
    @ApiOperation("导入物料产品数据")
    @PostMapping("/importData")
    public ResponseEntity<String> importFromExcel(MultipartFile file, boolean updateSupport){
        return null;
    }

}
