package com.zeroone.star.sysmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

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
@EnableDiscoveryClient // 开启服务注册与发现
public class sysManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(sysManagementApplication.class, args);
    }

}
