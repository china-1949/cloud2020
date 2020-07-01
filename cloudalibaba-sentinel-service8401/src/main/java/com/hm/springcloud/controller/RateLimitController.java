package com.hm.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;


import com.hm.springcloud.entities.CommonResult;
import com.hm.springcloud.entities.Payment;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RateLimitController {

    @GetMapping("/byResource")
    @SentinelResource(value = "byResource",blockHandler = "handleException")
    public CommonResult byResource() {
        return new CommonResult(200,"按资源名称限流测试OK",new Payment(2020L,"serial001"));
    }

    public CommonResult handleException(BlockException exception) { //自定义兜底
        return new CommonResult(444,exception.getClass().getCanonicalName()+"\t服务不可用");
    }


    //*******************************************************************

    @GetMapping("/rateLimit/byUrl")
    @SentinelResource(value = "byUrl")  //系统自带
    public CommonResult byUrl() {
        return new CommonResult(200,"按URL限流测试OK",new Payment(2020L,"serial002"));
    }

    //返回：Blocked by Sentinel (flow limiting)

}
