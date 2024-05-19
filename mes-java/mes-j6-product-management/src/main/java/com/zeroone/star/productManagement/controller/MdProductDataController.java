package com.zeroone.star.productManagement.controller;

import com.zeroone.star.project.components.sms.aliyun.SmsResult;
import com.zeroone.star.project.j6.product_management.MdProductDataApis;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

@Controller
@Api(tags = "product-management")
@RequestMapping("/mes/md/vendor")
public class MdProductDataController implements MdProductDataApis {
    //导出产品列表
    @ApiOperation("导出产品列表")
    @PostMapping("/export")
    public void export(HttpServletResponse response) {

    }
    //下载导入模板
    @ApiOperation("下载导入模板")
    @PostMapping("/importTemplate")
    public void importTemplate(HttpServletResponse response) {

    }
    //导入产品数据
    @ApiOperation("导入产品数据")
    @PostMapping("/importData")
    public SmsResult importData(MultipartFile file, boolean updateSupport) throws Exception {
        return null;
    }
}
