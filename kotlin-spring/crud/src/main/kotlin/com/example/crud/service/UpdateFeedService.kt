package com.example.crud.service

import com.example.crud.controller.dto.request.UpdateFeedRequest
import com.example.crud.entity.Feed
import com.example.crud.repository.FeedRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import kotlin.RuntimeException

@Service
class UpdateFeedService(
        private val feedRepository: FeedRepository,
) {

    fun execute(feedId: Long, request: UpdateFeedRequest) {

        val feed: Feed = feedRepository.findByIdOrNull(feedId) ?: throw RuntimeException()

        feed.update(
                title = request.title,
                content = request.content,
        )
    }
}