package com.hm.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
public class FlowLimitController {

    @RequestMapping("testA")
    public String testA(){
        try {
            TimeUnit.MICROSECONDS.sleep(800); //0.8s
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "testA-------";
    }

    @RequestMapping("testB")
    public String testB(){
        return "testB-------";
    }


}
