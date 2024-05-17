package com.zeroone.star.pdf.components;

import com.zeroone.star.project.components.pdf.PdfComponent;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 描述：书写一个PDF测试组件
 * </p>
 * <p>版权：&copy;01星球</p>
 * <p>地址：01星球总部</p>
 * @author 阿伟学长
 * @version 1.0.0
 */
@ComponentScan("com.zeroone.star.project.components.pdf")
@Component
public class TestPdf {
    @Resource
    PdfComponent pdf;

    private final String outputPath = "E:\\pdf\\Freemarker.pdf";

    public void testPdf() {
        // 设置模板数据
        Map<String, Object> data = new HashMap<>(2);
        // 定义数据list
        List<String> list = new ArrayList<>(2);
        list.add("hello");
        list.add("world");
        // 设置值
        data.put("list", list);
        data.put("str", "hello world");
        // 转换pdf
        pdf.generateToFile("template.fo", data, outputPath);
    }

    public void testBarcode() {
        // 设置模板数据
        Map<String, Object> data = new HashMap<>(2);
        data.put("url", "https://www.baidu.com");
        data.put("keywords", "百度");
        data.put("barcode", "11223344");
        // 转换pdf
        pdf.generateToFile("barcode.fo", data, outputPath);
    }
}
