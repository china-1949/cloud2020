package com.hm.springcloud.service;

import org.springframework.stereotype.Component;
//处理调用客户端提供者宕机的方案
@Component
public class PaymentFallbackService implements PaymentHystrixService {
    @Override
    public String paymentInfo_OK(Integer id) {
        return "--------PaymentFallbackService fallback --paymentInfo_OK ,o(╥﹏╥)o！！";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "--------PaymentFallbackService fallback --paymentInfo_TimeOut  ,o(╥﹏╥)o！！";
    }
}
