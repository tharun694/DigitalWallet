package com.DigitalWalletEngine.demo.Configuration;


import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class RabbitConfig {

    @Bean
    public org.springframework.amqp.core.Queue queue(){
        return new Queue("audit.queue");
    }
}
