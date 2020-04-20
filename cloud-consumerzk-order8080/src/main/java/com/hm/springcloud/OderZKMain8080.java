package com.hm.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class OderZKMain8080 {
    public static void main(String[] args) {
        SpringApplication.run(OderZKMain8080.class,args);
    }
}
