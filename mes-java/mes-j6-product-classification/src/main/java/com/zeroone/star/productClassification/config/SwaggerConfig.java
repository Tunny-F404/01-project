package com.zeroone.star.productClassification.config;

import com.zeroone.star.project.config.swagger.SwaggerCore;
import springfox.documentation.spring.web.plugins.Docket;

public class SwaggerConfig {
    Docket api() {
        return SwaggerCore.defaultDocketBuilder("物料分类模块",
                "com.zeroone.star.productClassification.controller",
                "productClassification");
    }
}
