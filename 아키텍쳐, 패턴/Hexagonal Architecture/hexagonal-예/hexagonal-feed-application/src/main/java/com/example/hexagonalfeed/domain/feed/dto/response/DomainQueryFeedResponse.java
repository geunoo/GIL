package com.example.hexagonalfeed.domain.feed.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Builder
public class DomainQueryFeedResponse {

    private final UUID feedId;
    private final String title;
    private final String content;
    private final LocalDateTime createdAt;
}
