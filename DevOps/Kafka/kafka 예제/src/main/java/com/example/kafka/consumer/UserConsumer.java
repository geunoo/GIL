package com.example.kafka.consumer;

import com.example.kafka.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class UserConsumer {

    @KafkaListener(topics = "user", groupId = "foo", containerFactory = "userContainerFactory")
    public void consume(User user) {
        System.out.println(user.toString());
        System.out.println(user.getName());
    }
}
