package com.foureverhh.example.springcloudrabbitmqtopicconsumer.consumer;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(
        bindings = @QueueBinding(
                exchange = @Exchange(
                     value = "${mq.config.exchange}",
                     type = ExchangeTypes.TOPIC  
                ),
                value= @Queue(
                        value = "${mq.config.queue.error}"
                ),
                key = "*.log.error"
        )
)
public class ErrorConsumer {
    
    @RabbitHandler
    public void process(String msg){
        System.out.println("*.log.error -> " + msg);
    }
}
