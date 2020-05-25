package com.hm.springcloud.controller;

import com.hm.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;
    @Value("${server.port}")
    private String serverPort;
    @GetMapping(value = "/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id){
        String paymentInfo_ok = paymentService.paymentInfo_OK(id);
        log.info("*******result: "+paymentInfo_ok);
        return  paymentInfo_ok;
    }

    //tomcat的默认工作线程数被打满了,没有多余的线程来分解压力和处理
    @GetMapping(value = "/payment/hystrix/timeout/{id}")
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id){
        String paymentInfo_timeOut = paymentService.paymentInfo_TimeOut(id);
        log.info("*******result: "+paymentInfo_timeOut);
        return  paymentInfo_timeOut;
    }
    //=======服务熔断
    @GetMapping(value = "/payment/circuit/{id}")
    public String paymentCircuitBreaker (@PathVariable("id") Integer id){
        String result = paymentService.paymentCircuitBreaker(id);
        log.info("********result:  "+result);
        return  result;
    }
}
