package com.hm.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class OderConsulMain8080 {
    public static void main(String[] args) {

        SpringApplication.run(OderConsulMain8080.class,args);
    }
}
