package com.zeroone.star.customer.config;

import com.zeroone.star.project.config.swagger.SwaggerCore;
import springfox.documentation.spring.web.plugins.Docket;

public class SwaggerConfig {
    Docket api() {
        return SwaggerCore.defaultDocketBuilder("客户管理模块", "com.zeroone.star.customer.controller","customer");
    }
}
