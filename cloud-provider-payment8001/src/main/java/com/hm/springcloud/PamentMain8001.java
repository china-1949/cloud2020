package com.hm.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient  //客户端提供者
@EnableDiscoveryClient //服务发现Discovery
public class PamentMain8001 {
    public static void main(String[] args) {
        SpringApplication.run(PamentMain8001.class,args);
    }
}
