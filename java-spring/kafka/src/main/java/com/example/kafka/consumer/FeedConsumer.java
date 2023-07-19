package com.example.kafka.consumer;

import com.example.kafka.domain.Feed;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class FeedConsumer {

    @KafkaListener(topics = "feed", groupId = "bar")
    public void consume(String feed) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Feed feed1 = objectMapper.readValue(feed, Feed.class);
            System.out.println(feed1.toString());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
