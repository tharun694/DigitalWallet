package com.DigitalWalletEngine.demo;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class AuditConsumer {
    @RabbitListener(queues = "audit.queue")
    public void consume(String message){
        System.out.println(message);
    }
}
