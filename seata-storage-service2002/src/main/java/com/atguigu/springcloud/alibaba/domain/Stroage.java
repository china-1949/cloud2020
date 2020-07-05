package com.atguigu.springcloud.alibaba.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor //全参数
@NoArgsConstructor  //无参数
public class Stroage {
    private Long id; //主键
    private  Long productId; //产品id
    private Integer total; //库存
    private Integer used;  //已经用了
    private Integer residue;  //剩余量
}
