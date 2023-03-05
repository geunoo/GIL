package com.example.crud.service

import com.example.crud.entity.Feed
import com.example.crud.repository.FeedRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class DeleteFeedService(
        private val feedRepository: FeedRepository,
) {

    @Transactional
    fun execute(feedId: Long) {
        val feed: Feed = feedRepository.findByIdOrNull(feedId) ?: throw RuntimeException();
        feedRepository.delete(feed)
    }
}