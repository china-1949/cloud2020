package com.hm.springcloud.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data  //get  set 方法
@AllArgsConstructor  //全参构造
@NoArgsConstructor //无参构造
public class Payment implements Serializable {
    private  Long id;
    private  String serial;

}
