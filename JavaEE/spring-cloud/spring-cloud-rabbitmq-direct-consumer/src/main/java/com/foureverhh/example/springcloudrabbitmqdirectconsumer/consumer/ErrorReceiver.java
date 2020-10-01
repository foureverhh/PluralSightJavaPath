package com.foureverhh.example.springcloudrabbitmqdirectconsumer.consumer;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;
/*
* 消息接收者
* @RabbitListener
*       绑定队列和交换器
*       bindings=@QueueBinding(
*           value=@Queue(
*                 value="${mq.config.queue.info}", //queue的名称
*                 autoDelete="true" //当前queue是不是一个可删除的临时队列
*           ),
*           exchange=@Exchange(
*                  value="${mq.config.exchange}", //exchange的名称
*                  type=ExchangeTypes.DIRECT, //指定路由的类型
*           ),
*            key="${mq.config.queue.info.routing.key}" //指定routing-key
*       )
* */
@Component
@RabbitListener(
        bindings = @QueueBinding(
                value = @Queue(
                        value = "${mq.config.queue.info}",
                        autoDelete = "true"
                ),
                exchange = @Exchange(
                        value = "${mq.config.exchange}",
                        type = ExchangeTypes.DIRECT
                ),
                key = "${mq.config.queue.info.routing.key}"
        )
)
public class InfoReceiver {
   @RabbitHandler
    public void process(String msg){
        System.out.println(msg);
    }
}
