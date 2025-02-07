package com.hm.springcloud;

import com.hm.myrule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableEurekaClient  //客户端消费者
@RibbonClient(name = "CLOUD-PAYMENT-SERVICE",configuration = MySelfRule.class)

//默认轮询，自己的MySelfRule设置自带的规则，LoadBalance接口自定义规则
public class OderMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OderMain80.class,args);
    }
}
