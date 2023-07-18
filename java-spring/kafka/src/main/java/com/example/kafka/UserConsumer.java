package com.example.kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class UserConsumer {

    @KafkaListener(topics = "user", groupId = "foo")
    public void consume(String user) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            User user1 = objectMapper.readValue(user, User.class);
            System.out.println(user1.toString());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
