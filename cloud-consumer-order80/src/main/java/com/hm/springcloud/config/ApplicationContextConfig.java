package com.hm.springcloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

//需要引入ResTemplate
@Configuration
public class ApplicationContextConfig {
    @Bean  //注入容器
    public RestTemplate getRestTemplate(){
        return  new RestTemplate();
    }
}
