package com.hm.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

//需要引入ResTemplate
@Configuration
public class ApplicationContextConfig {
    @Bean  //注入容器
   // @LoadBalanced  //开启RestTemplate的负载均衡 ,默认轮询找到对应的提供者主机  但是自己写算法规则不需要加
    public RestTemplate getRestTemplate(){
        return  new RestTemplate();
    }
}
