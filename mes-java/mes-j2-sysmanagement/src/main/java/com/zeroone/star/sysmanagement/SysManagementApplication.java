package com.zeroone.star.sysmanagement;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * <p>
 * SysManagementApplication
 * @author j2
 * @version 1.0.0
 */
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.zeroone.star.sysmanagement.mapper")
public class SysManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(SysManagementApplication.class, args);
    }

}
