package com.hm.springcloud.controller;

import com.hm.springcloud.entities.CommonResult;
import com.hm.springcloud.entities.Payment;
import com.hm.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderFeignController {
    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        return  paymentFeignService.getPaymentById(id);
    }

    @GetMapping(value = "/consumer/payment/feign/timeout")
    public  String paymentFeignTimeOut(){
        //openfeign-ribbon, 客户端默认等待1s
        return  paymentFeignService.paymentFeignTimeOut();
    }

}
