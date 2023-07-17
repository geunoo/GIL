package com.example.kafka;

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

    @PostMapping
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
}
