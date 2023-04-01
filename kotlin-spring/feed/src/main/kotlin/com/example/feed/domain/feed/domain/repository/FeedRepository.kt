package com.example.feed.domain.feed.domain.repository

import com.example.feed.domain.feed.domain.Feed
import com.example.feed.domain.feed.domain.QFeed.feed
import com.example.feed.domain.feed.presentation.dto.response.QQueryFeedsResponse
import com.example.feed.domain.feed.presentation.dto.response.QueryFeedsResponse
import com.example.feed.domain.user.domain.QUser.user
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
class FeedRepository(
    private val feedJpaRepository: FeedJpaRepository,
    private val jpaQueryFactory: JPAQueryFactory,
) {

    fun saveFeed(feed: Feed): Feed =
        feedJpaRepository.save(feed)

    fun queryFeeds(): List<QueryFeedsResponse> =
        jpaQueryFactory
            .select(
                QQueryFeedsResponse(
                    feed.id,
                    feed.title,
                    feed.content,
                    user.name,
                    feed.createdAt
                )
            )
            .from(feed)
            .join(feed.user, user)
            .orderBy(feed.createdAt.desc())
            .fetch()

    fun queryFeedById(id: UUID) =
        feedJpaRepository.findByIdOrNull(id)

    fun deleteFeed(feed: Feed) {
        feedJpaRepository.delete(feed)
    }
}