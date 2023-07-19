package com.example.kafka;

import com.example.kafka.domain.Feed;
import com.example.kafka.domain.User;
import com.example.kafka.producer.FeedProducer;
import com.example.kafka.producer.UserProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/kafka")
@RestController
public class KafkaController {

    private final UserProducer userProducer;
    private final FeedProducer feedProducer;

    @PostMapping("/user")
    public void sendUserMessage(@RequestBody UserRequest request) {
        userProducer.sendMessage(
                User.builder()
                        .name(request.getName())
                        .age(request.getAge())
                        .height(request.getHeight())
                        .weight(request.getWeight())
                        .build()
        );
    }

    @PostMapping("/feed")
    public void sendFeedMessage(@RequestBody FeedRequest request) {
        feedProducer.sendMessage(
                Feed.builder()
                        .title(request.getTitle())
                        .content(request.getContent())
                        .build()
        );
    }
}
