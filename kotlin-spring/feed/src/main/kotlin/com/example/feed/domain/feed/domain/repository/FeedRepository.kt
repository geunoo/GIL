package com.example.feed.domain.feed.domain.repository

import com.example.feed.domain.feed.domain.Feed
import org.springframework.stereotype.Repository

@Repository
class FeedRepository(
    private val feedJpaRepository: FeedJpaRepository,
) {

    fun saveFeed(feed: Feed): Feed =
        feedJpaRepository.save(feed)
}