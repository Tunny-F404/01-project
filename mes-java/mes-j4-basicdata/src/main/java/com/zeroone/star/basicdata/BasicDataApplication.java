package com.zeroone.star.basicdata;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
//import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * <p>
 * 描述：服务器启动入口
 * </p>
 * <p>版权：&copy;01星球</p>
 * <p>地址：01星球总部</p>
 * @author 阿伟学长
 * @version 1.0.0
 */
@SpringBootApplication
@EnableDiscoveryClient
@Slf4j
//@EnableFeignClients
public class BasicDataApplication {

    public static void main(String[] args) {
        SpringApplication.run(com.zeroone.star.basicdata.BasicDataApplication.class, args);
        log.info("项目启动成功。。。");
    }

}
