package com.example.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class UserConsumer {

    @KafkaListener(topics = "user", groupId = "foo")
    public void consume(String user) {
        System.out.println(
                user
        );
    }
}
