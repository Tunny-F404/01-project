package com.zeroone.star.productManagement.controller;

import com.zeroone.star.project.components.sms.aliyun.SmsResult;
import com.zeroone.star.project.j6.product_management.MdProductDataApis;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

public class MdProductDataController implements MdProductDataApis {
    //导出产品列表
    public void export(HttpServletResponse response) {

    }
    //下载导入模板
    public void importTemplate(HttpServletResponse response) {

    }
    //导入产品数据
    public SmsResult importData(MultipartFile file, boolean updateSupport) throws Exception {
        return null;
    }
}
