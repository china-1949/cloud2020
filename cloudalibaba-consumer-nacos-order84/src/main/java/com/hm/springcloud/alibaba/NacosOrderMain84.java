package com.hm.springcloud.alibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients  //激活FeignClients
public class NacosOrderMain84 {
    //sentinel整合ribbon+openFeign+fallback
    public static void main(String[] args) {
        SpringApplication.run(NacosOrderMain84.class,args);
    }
}
