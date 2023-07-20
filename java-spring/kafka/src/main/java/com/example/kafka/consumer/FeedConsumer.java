package com.example.kafka.consumer;

import com.example.kafka.domain.Feed;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class FeedConsumer {


    @KafkaListener(topics = "feed", groupId = "bar", containerFactory = "feedContainerFactory")
    public void consume(Feed feed) {
        System.out.println(feed.toString());
        System.out.println(feed.getContent());
    }
}
