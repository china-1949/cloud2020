package com.hm.springcloud.controller;

import com.hm.springcloud.entities.CommonResult;
import com.hm.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderController {
    //以前使用httpClient ，webService，现在视同RestTmeplate(封装前面的httpClient)

    public static final  String PAYMENT_URL ="http://localhost:8001";
    @Resource
    private RestTemplate restTemplate;

    /**
     *
     *   <T> T postForObject(URI var1, @Nullable Object var2, Class<T> var3) throws RestClientException;
     */
    @GetMapping(value = "/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment){
        return  restTemplate.postForObject(PAYMENT_URL+"/payment/create",payment,CommonResult.class);

    }

    /**
     *
     *  <T> T getForObject(URI var1, Class<T> var2) throws RestClientException;
     */
    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id){
        return  restTemplate.getForObject(PAYMENT_URL+"/payment/get/"+id,CommonResult.class);
    }


}
