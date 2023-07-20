package com.example.kafka.consumer;

import com.example.kafka.JsonConverter;
import com.example.kafka.domain.Feed;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class FeedConsumer {

    private final JsonConverter<Feed> jsonConverter;

    @KafkaListener(topics = "feed", groupId = "bar")
    public void consume(String feedString) {
        Feed feed = jsonConverter.convert(feedString, Feed.class);
        System.out.println(feed.toString());
    }
}
