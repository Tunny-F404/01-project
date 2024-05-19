package com.zeroone.star.sysmanagement.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author 40斤
 * @version 1.0.0
 * @Description: //扫描 common模块中的 fastDfs , easyexcel 方便测试
 */
@Configuration
@ComponentScan({
        "com.zeroone.star.project.components.fastdfs",
        "com.zeroone.star.project.components.easyexcel"
}) //扫描fastDfs ,  easyexcel
public class componentInit {

}
