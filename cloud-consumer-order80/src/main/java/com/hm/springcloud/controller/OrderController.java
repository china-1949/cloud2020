package com.hm.springcloud.controller;

import com.hm.springcloud.entities.CommonResult;
import com.hm.springcloud.entities.Payment;
import com.hm.springcloud.lb.LoadBalance;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

@RestController
@Slf4j
public class OrderController {
    //以前使用httpClient ，webService，现在视同RestTmeplate(封装前面的httpClient)

  //  public static final  String PAYMENT_URL ="http://localhost:8001"; //单机版地址
    public static  final  String  PAYMENT_URL= "http://CLOUD-PAYMENT-SERVICE"; //集群版服务名称地址
    @Resource
    private RestTemplate restTemplate;

    @Resource
    private LoadBalance loadBalance;

    @Resource
    private DiscoveryClient discoveryClient;

    /**
     *
     *   <T> T postForObject(URI var1, @Nullable Object var2, Class<T> var3) throws RestClientException;
     */
    @GetMapping(value = "/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment){
        return  restTemplate.postForObject(PAYMENT_URL+"/payment/create",payment,CommonResult.class);

    }

    /**
     *
     *  <T> T getForObject(URI var1, Class<T> var2) throws RestClientException;
     */
    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id){
        return  restTemplate.getForObject(PAYMENT_URL+"/payment/get/"+id,CommonResult.class);
    }



  @GetMapping(value = "/consumer/paymentForEntity/create")
  public CommonResult<Payment> create2(Payment payment){
    ResponseEntity<CommonResult> entity = restTemplate.postForEntity(PAYMENT_URL + "/payment/create", payment, CommonResult.class);
    if(entity.getStatusCode().is2xxSuccessful()){
      return entity.getBody();
    }
    return  new CommonResult<>(444,"操作失败！！");
  }

    @GetMapping(value = "/consumer/payment/getForEntity/{id}")
    public CommonResult<Payment> getPayment2(@PathVariable("id") Long id){
      ResponseEntity<CommonResult> entity = restTemplate.getForEntity(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
      if(entity.getStatusCode().is2xxSuccessful()){
        log.info(entity.getStatusCode()+"\t"+entity.getHeaders());
        return entity.getBody();
      }
      return  new CommonResult<>(444,"操作失败！！");
    }
  //现在只有这个接口演示成功，上面getInstances方式不对
    @GetMapping(value = "/consumer/payment/lb")
    public  String getPaymentLB(){
      List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
      if(null==instances || instances.size()<=0){
        return  null;
      }

      ServiceInstance serviceInstance =loadBalance.instances(instances);
      URI uri = serviceInstance.getUri();  //此时上面的路径全部要用loadBalance

      return  restTemplate.getForObject(uri+"/payment/lb",String.class);
    }
}
