package com.elif.rabbitmq.producer;

import com.elif.rabbitmq.model.UserModel;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserProducer {
    private final RabbitTemplate rabbitTemplate;

    public void sendUserMessage(UserModel model){
        rabbitTemplate.convertAndSend("auth-exchange","auth-binding-key",model);
    }
}
