package com.zeroone.star.sysmanagent.config;

import com.zeroone.star.project.config.swagger.SwaggerCore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

/**
 * @author 宵夜
 * @version 1.0.0
 * @Description: TODO
 */
@Configuration
@EnableSwagger2WebMvc
public class swaggerConfig {

    @Bean
    Docket DepartmentApis() {
        return SwaggerCore.defaultDocketBuilder("部门模块","com.zeroone.star.orgstructure.controller","orgstructure");
}


}
