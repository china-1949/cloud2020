package com.hm.springcloud.controller;

import com.hm.springcloud.entities.CommonResult;
import com.hm.springcloud.entities.Payment;
import com.hm.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    //获取端口号
    @Value("${server.port}")
    private  String serverPort;


    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment){  //@RequestBody  接受参数为Payment类型
        int result = paymentService.create(payment);
        log.info("**********插入结果："+result);
        if(result >0){
            return new CommonResult(200,"插入数据成功,serverPort: "+serverPort,result);
        }
        return  new CommonResult(444,"插入失败!!",null);


    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);

        if(null!=payment){

            return new CommonResult(200,"查询成功,serverPort: "+serverPort,payment+"\t"+"haihai");
        }
        return  new CommonResult(444,"没有对应数据"+id,null);
    }

    /**
     * 查看注册是否成功
     * @return
     */
    @GetMapping(value = "/payment/discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        for (String element:services
             ) {
            log.info("******element: "+element);  //注册所有的服务
        }

        List<ServiceInstance> instances = discoveryClient.getInstances("cloud-provider-payment");
        for (ServiceInstance instance: instances
             ) {
            log.info(instance.getServiceId()+"\t"+instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri());  //该服务的主机信息
        }

        return  this.discoveryClient;
    }


    /**
     * 测试
     * @return
     */
    @RequestMapping("/payment/zk")
    public String paymentzk(){
        return "springcloud with zookeeper:" + serverPort +"\t" + UUID.randomUUID().toString();
    }


}
