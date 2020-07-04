package com.hm.springcloud.alibaba.service;


import com.hm.springcloud.entities.CommonResult;
import com.hm.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//测试84调用9003，此时故意关闭9003微服务提供者，看84消费者侧自动降级
@FeignClient(value = "nacos-payment-provider",fallback =PaymentFallbackService.class ) //fallback降级
public interface PaymentService {

    @GetMapping(value = "/paymentSQL/{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable("id") Long id);
}
