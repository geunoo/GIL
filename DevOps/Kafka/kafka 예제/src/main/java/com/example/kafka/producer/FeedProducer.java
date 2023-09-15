package com.example.kafka.producer;

import com.example.kafka.domain.Feed;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class FeedProducer {

    private final KafkaTemplate<String, Feed> kafkaTemplate;

    public void sendMessage(Feed feed) {
        System.out.println(feed.toString());

        kafkaTemplate.send("feed", feed);
    }
}
