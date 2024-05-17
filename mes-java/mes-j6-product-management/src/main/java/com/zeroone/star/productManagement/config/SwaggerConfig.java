package com.zeroone.star.productManagement.config;

import com.zeroone.star.project.config.swagger.SwaggerCore;
import springfox.documentation.spring.web.plugins.Docket;

public class SwaggerConfig {
    Docket Api() {
        return SwaggerCore.defaultDocketBuilder("物料管理模块",
                "com.zeroone.star.productManagement.controller",
                "productManagement");
    }
}
