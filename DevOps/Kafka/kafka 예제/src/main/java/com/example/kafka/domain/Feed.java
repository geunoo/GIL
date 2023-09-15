package com.example.kafka.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class Feed {

    private String title;
    private String content;

    @Builder
    public Feed(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
