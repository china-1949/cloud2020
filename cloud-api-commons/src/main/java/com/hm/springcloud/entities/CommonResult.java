package com.hm.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor //全参数
@NoArgsConstructor  //无参数
public class CommonResult <T>{
    //
    private Integer code;
    private  String message;
    private T  data;

    public  CommonResult(Integer code,String message){
        this(code,message,null);
    }


}
