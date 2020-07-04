package com.hm.springcloud.alibaba.service;

import com.hm.springcloud.entities.CommonResult;
import com.hm.springcloud.entities.Payment;
import org.springframework.stereotype.Component;

@Component
public class PaymentFallbackService implements PaymentService {
    @Override
    public CommonResult<Payment> paymentSQL(Long id) {
        return new CommonResult<>(444,"服务降级返回---PaymentFallbackService",new Payment(id,"errorService"));
    }
}
