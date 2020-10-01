package com.foureverhh.example.springcloudrabbitmqdirectprovider.provider;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class InfoSender {

    @Resource
    private AmqpTemplate amqpTemplate;

    @Value("${mq.config.exchange}")
    private String exchange;

    @Value("${mq.config.queue.info.routing.key}")
    private String key;

    public void infoSend(String msg){
        /*
        * 向消息队列发送消息
        * 参数一：交换器名称
        * 参数二：路由键
        * 参数三：消息
        * */
        amqpTemplate.convertAndSend(exchange,key,msg);
    }
}
