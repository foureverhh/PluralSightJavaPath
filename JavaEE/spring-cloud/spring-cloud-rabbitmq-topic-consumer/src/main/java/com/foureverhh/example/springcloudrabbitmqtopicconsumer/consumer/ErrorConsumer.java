package com.foureverhh.example.springcloudrabbitmqtopicconsumer.consumer;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
@RabbitListener(
        bindings = @QueueBinding(
                exchange = @Exchange(
                     value = "${mq.config.exchange}",
                     type = ExchangeTypes.TOPIC
                ),
                value= @Queue(
                        value = "${mq.config.queue.info}"
                ),
                key = "*.log.info"
        )
)
public class InfoConsumer {

    @RabbitHandler
    public void process(String msg){
        System.out.println("*.log.info -> " + msg);
    }
}
