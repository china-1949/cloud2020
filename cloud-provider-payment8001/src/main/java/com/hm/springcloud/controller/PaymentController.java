package com.hm.springcloud.controller;

import com.hm.springcloud.entities.CommonResult;
import com.hm.springcloud.entities.Payment;
import com.hm.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;


import javax.annotation.Resource;

@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment){  //@RequestBody  接受参数为Payment类型
        int result = paymentService.create(payment);
        log.info("**********插入结果："+result);
        if(result >0){
            return new CommonResult(200,"插入数据成功",result);
        }
        return  new CommonResult(444,"插入失败!!",null);


    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);

        if(null!=payment){

            return new CommonResult(200,"查询成功",payment+"\t"+"hiahjiasdsfefetr");
        }
        return  new CommonResult(444,"没有对应数据"+id,null);
    }

}
