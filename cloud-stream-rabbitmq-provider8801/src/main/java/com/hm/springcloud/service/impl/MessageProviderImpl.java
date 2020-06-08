package com.hm.springcloud.service.impl;

import com.hm.springcloud.service.IMessageProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;
import java.util.UUID;

@Slf4j
@EnableBinding(Source.class) //定义消息的推送管道
public class MessageProviderImpl implements IMessageProvider {
    @Resource
    private MessageChannel output;  //消息发送管道

    @Override
    public String send() {
        UUID serial = UUID.randomUUID();
        output.send(MessageBuilder.withPayload(serial).build());
        //https://cloud.spring.io/spring-cloud-static/spring-cloud-stream-binder-rabbit/3.0.1.RELEASE/reference/html/spring-cloud-stream-binder-rabbit.html#_partitioning_with_the_rabbitmq_binder
        log.info("*******serial: "+serial);
        return null;
    }
}
