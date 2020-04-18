package com.hm.springcloud.dao;

import com.hm.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper  //@Repository 该注解插入可能存在问题
public interface PaymentDao {

    public  int create(Payment payment);

    public  Payment getPaymentById(@Param("id") Long id);


}
