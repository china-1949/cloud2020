package com.hm.springcloud.controller;

import com.hm.springcloud.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
@DefaultProperties(defaultFallback = "payment_Global_FallbackMethod")  //全局的兜底处理的方案
public class OrderHyrixController {
    @Resource
    private PaymentHystrixService paymentHystrixService;

    @GetMapping(value = "/consumer/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id){
       return paymentHystrixService.paymentInfo_OK(id);
    }
    //具体方法兜底
    @GetMapping(value = "/consumer/payment/hystrix/timeout/{id}")
    @HystrixCommand(fallbackMethod = "paymentTimeOutFallbackMethod",commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "1500")
    })
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id){
        //超时操作与计算异常
        //int age =10/0;
        return paymentHystrixService.paymentInfo_TimeOut(id);
    }
    //全局兜底
    @GetMapping(value = "/consumer/payment/hystrix/timeout2/{id}")
    @HystrixCommand
    public String paymentInfo_TimeOut2(@PathVariable("id") Integer id){
        //超时操作与计算异常
        int age =10/0;
        return paymentHystrixService.paymentInfo_TimeOut(id);
    }

    //客户端出错兜底处理方法
    public String paymentTimeOutFallbackMethod(@PathVariable("id") Integer id){
        return "我是消费者80，对方支付系统繁忙请10s钟后再试，或者自己运行运行出错请检查自己，o(╥﹏╥)o";
    }
    //下面是全局fallback方法
    public  String payment_Global_FallbackMethod(){
        return "Global异常处理信息，请稍后再试，o(╥﹏╥)o！！";
    }

}
