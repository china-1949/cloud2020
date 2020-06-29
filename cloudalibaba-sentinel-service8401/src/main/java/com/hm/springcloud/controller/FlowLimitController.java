package com.hm.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class FlowLimitController {

    @RequestMapping("testA")
    public String testA(){
        /*try {
            TimeUnit.MICROSECONDS.sleep(800); //0.8s
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        return "testA-------";
    }

    @RequestMapping("testB")
    public String testB(){
        log.info(Thread.currentThread().getName()+"\t"+".....testB");
        return "testB-------";
    }


    @RequestMapping("testD")
    public String testD(){
         try {
            TimeUnit.SECONDS.sleep(1); //1s
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("testD 测试RT");
       return "----testD";
    }

    @RequestMapping("testE")
    public String testE(){

        log.info("testE 测试异常比例");
        int age=10/0;
        return "----testE：异常比例";
    }

    @RequestMapping("testF")
    public String testF(){

        log.info("testF 测试异常数");
        int age=10/0;
        return "----testF：测试异常数";
    }

    @GetMapping(value = "/testHotKey")
    @SentinelResource(value = "testHotKey",blockHandler = "deal_testHotKey")
    public String testHotKey(@RequestParam (value = "p1",required = false) String p1,
                             @RequestParam (value = "p2",required = false) String p2){
      //  int age=100/0; //java运行时报出的运行异常RunTimeException,@SentinelResource不管
        return "----testHotKey";
    }
    //testHotKey： Blocked by Sentinel (flow limiting)
    public String deal_testHotKey(String p1,String p2,BlockException exception){
        return "deal_testHotKey,o(╥﹏╥)o";
        //sentinel 系统默认提示；Blocked by Sentinel (flow limiting) ，改为哭脸
    }


}
