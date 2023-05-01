package com.example.hexagonalfeed.domain.feed.domain;

import com.example.hexagonalfeed.common.annotation.Aggregate;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Builder
@Aggregate
public class Feed {

    private final UUID id;
    private final String title;
    private final String content;
    private final LocalDateTime createdAt;
}
