package com.zeroone.star.orgstructure;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * <p>
 * OrgStructureApplication
 * @author j2
 * @version 1.0.0
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class OrgStructureApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrgStructureApplication.class, args);
    }

}
