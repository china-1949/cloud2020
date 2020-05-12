package com.hm.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 手写轮询
 */
@Component
public class LoadBalanceImpl implements LoadBalance {
    //使用(CAS+自旋锁）不用synchronize
    private AtomicInteger atomicInteger =new AtomicInteger(0);  //原子类

    public  final  int getAndIncrement(){
        int current;
        int next;
        do{
            current=this.atomicInteger.get();
            next=current>=2147483647?0:current+1;
        }while (!this.atomicInteger.compareAndSet(current,next));
        System.out.println("*********第几次访问，次数next:"+next);
        return  next;
    }
    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {
        int index = getAndIncrement() %  serviceInstances.size();

        return serviceInstances.get(index);
    }
}
