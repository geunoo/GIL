package com.example.kafka;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class UserProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(User user) {
        System.out.println("send user" + user.toString());

//        Message<User> message = MessageBuilder
//                .withPayload(user)
//                .setHeader(KafkaHeaders.TOPIC, "user")
//                .build();

        kafkaTemplate.send("user", user.toString());
    }
}
