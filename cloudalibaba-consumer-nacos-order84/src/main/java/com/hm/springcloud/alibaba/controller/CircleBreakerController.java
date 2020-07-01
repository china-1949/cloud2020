package com.hm.springcloud.alibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.hm.springcloud.entities.CommonResult;
import com.hm.springcloud.entities.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.HashMap;

@RestController
public class CircleBreakerController {

    @Value("${server.port}")
    private String serverPort;

    public static final String SERVICE_URL="http://nacos-payment-provider";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/fallback/{id}")
  //  @SentinelResource(value = "fallback")  //没有配置
  //    @SentinelResource(value = "fallback",fallback = "handlerFallback")  //fallback只负责业务异常  相当于Hystrix的服务降级
    @SentinelResource(value = "fallback",blockHandler = "blockHandler") //blockHandler只负责sentine控制台配置违规
    public CommonResult<Payment> fallback(@PathVariable("id") Long id) {
        CommonResult<Payment> result = restTemplate.getForObject(SERVICE_URL+"/paymentSQL/"+id,CommonResult.class,id);
        if (id==4) {
            throw new IllegalArgumentException("IllegalArgumentException,非法参数异常....");
        } else if (result.getData() == null) {
            throw new NullPointerException("NullPointerException,该ID没有对应记录，空指针异常");
        }
        return result;
    }

    //本例子是fallback的  此时不会出现 Whitelabel Error Page
//    public CommonResult handlerFallback(@PathVariable("id") Long id, Throwable e) {
//        Payment payment = new Payment(id,"null");
//        return new CommonResult(444,"兜底异常handlerFallback,exception内容"+e.getMessage(),payment);
//    }

    //本例是只有blockHandler
    public CommonResult blockHandler(@PathVariable("id") Long id, BlockException blockException) {
        Payment payment = new Payment(id,"null");
        return new CommonResult(445,"blockHandler-sentinel限流，无此流水：blockException:"+blockException.getMessage(),payment);
    }



}
