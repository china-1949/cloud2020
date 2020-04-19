package com.hm.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient  //客户端提供者
public class PamentMain8002 {
    public static void main(String[] args) {
        SpringApplication.run(PamentMain8002.class,args);
    }
}
