package com.example.kafka.consumer;

import com.example.kafka.JsonConverter;
import com.example.kafka.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class UserConsumer {

    private final JsonConverter<User> jsonConverter;

    @KafkaListener(topics = "user", groupId = "foo")
    public void consume(String userString) {
        User user = jsonConverter.convert(userString, User.class);
        System.out.println(user.toString());
    }
}
