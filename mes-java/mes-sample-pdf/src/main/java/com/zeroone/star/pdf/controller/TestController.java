package com.zeroone.star.pdf.controller;

import com.zeroone.star.pdf.components.TestPdf;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 描述：测试访问控制器
 * </p>
 * <p>版权：&copy;01星球</p>
 * <p>地址：01星球总部</p>
 * @author 阿伟学长
 * @version 1.0.0
 */
@RestController
public class TestController {
    @Resource
    TestPdf pdf;

    @GetMapping("test-pdf")
    public int testPdf() {
        pdf.testPdf();
        return 1;
    }

    @GetMapping("test-barcode")
    public int testBarcode() {
        pdf.testBarcode();
        return 1;
    }
}
