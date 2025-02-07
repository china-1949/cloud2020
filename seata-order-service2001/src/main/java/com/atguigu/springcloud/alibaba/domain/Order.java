package com.atguigu.springcloud.alibaba.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor //全参数
@NoArgsConstructor  //无参数
public class Order {
    private Long id;
    private Long userId;
    private  Long productId;
    private Integer count;
    private BigDecimal money;
    private Integer status;  //订单状态  ：0 ：创建中；  1：完结
}
