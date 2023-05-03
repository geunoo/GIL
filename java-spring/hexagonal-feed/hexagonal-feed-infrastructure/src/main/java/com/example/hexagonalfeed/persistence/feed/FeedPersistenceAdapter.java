package com.example.hexagonalfeed.persistence.feed;

import com.example.hexagonalfeed.common.annotation.Adapter;
import com.example.hexagonalfeed.domain.feed.domain.Feed;
import com.example.hexagonalfeed.domain.feed.spi.FeedSpi;
import com.example.hexagonalfeed.persistence.feed.mapper.FeedMapper;
import com.example.hexagonalfeed.persistence.feed.repository.FeedJpaRepository;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;

import static com.example.hexagonalfeed.persistence.feed.entity.QFeedJpaEntity.feedJpaEntity;

@RequiredArgsConstructor
@Adapter
public class FeedPersistenceAdapter implements FeedSpi {

    private final FeedJpaRepository feedJpaRepository;
    private final FeedMapper feedMapper;
    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public Feed save(Feed feed) {
        return feedMapper.entityToDomain(
                feedJpaRepository.save(
                        feedMapper.domainToEntity(feed)
                )
        );
    }

    @Override
    public void delete(Feed feed) {
        feedJpaRepository.delete(
                feedMapper.domainToEntity(feed)
        );
    }

    @Override
    public List<Feed> queryFeeds() {
        return jpaQueryFactory
                .selectFrom(feedJpaEntity)
                .orderBy(feedJpaEntity.createdAt.desc())
                .fetch().stream()
                .map(feedMapper::entityToDomain)
                .toList();
    }
}
