package com.elif.rabbitmq.consumer;

import com.elif.dto.request.CreateUserRequestDto;
import com.elif.rabbitmq.model.UserModel;
import com.elif.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserConsumer {

    private final UserService userService;

    @RabbitListener(queues = "auth-queue")
    public void createUserListener(UserModel model){
        System.out.println("Kuyruk gelen mesaj..: "+ model);
        userService.createUser(CreateUserRequestDto.builder()
                .email(model.getEmail())
                .username(model.getUsername())
                .authId(model.getAuthId())
                .build());
    }
}
