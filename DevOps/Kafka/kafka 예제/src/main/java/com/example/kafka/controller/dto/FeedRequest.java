package com.example.kafka.controller.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class FeedRequest {

    private String title;
    private String content;
}
