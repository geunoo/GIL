package com.example.hexagonalfeed.persistence.feed.mapper;

import com.example.hexagonalfeed.domain.feed.domain.Feed;
import com.example.hexagonalfeed.persistence.feed.entity.FeedJpaEntity;
import org.springframework.stereotype.Component;

@Component
public class FeedMapper {

    public Feed entityToDomain(FeedJpaEntity feedJpaEntity) {
        return Feed.builder()
                .id(feedJpaEntity.getId())
                .title(feedJpaEntity.getTitle())
                .content(feedJpaEntity.getContent())
                .createdAt(feedJpaEntity.getCreatedAt())
                .build();
    }

    public FeedJpaEntity domainToEntity(Feed feed) {
        return FeedJpaEntity.builder()
                .id(feed.getId())
                .title(feed.getTitle())
                .content(feed.getContent())
                .createdAt(feed.getCreatedAt())
                .build();
    }
}
