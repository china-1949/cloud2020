package com.hm.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "CLOUD-PROVIDER-HISTRIX-PAYMENT",fallback =PaymentFallbackService.class)  //客户端提供者宕机处理：fallback =PaymentFallbackService.class
public interface PaymentHystrixService {
    /**
     * 对方服务(8001)超时了,调用者(80)不能一直卡死等待,必须有服务降级
     * 对方服务(8001)down机了,调用者(80)不能一直卡死等待,必须有服务降级
     * 对方服务(8001)ok,调用者(80)自己有故障或有自我要求(自己的等待时间小于服务提供者)
     * */
    @GetMapping(value = "/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id);

    @GetMapping(value = "/payment/hystrix/timeout/{id}")
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id);

}
