package com.atguigu.springcloud.alibaba.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor //全参数
@NoArgsConstructor  //无参数
public class Account {
    private Long id;
    private Long userId;
    private  BigDecimal total;
    private BigDecimal used;
    private BigDecimal residue;

}
