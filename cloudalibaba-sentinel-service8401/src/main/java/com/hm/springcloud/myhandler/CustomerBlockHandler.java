package com.hm.springcloud.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.hm.springcloud.entities.CommonResult;
import com.hm.springcloud.entities.Payment;

public class CustomerBlockHandler {
    public static CommonResult handlerException(BlockException exception){
        return new CommonResult(4444,"按客户自定义,全局的global handlerException ---1 ");
    }

    public static CommonResult handlerException2(BlockException exception){
        return new CommonResult(4444,"按客户自定义,全局的global handlerException----2 ");
    }
}
