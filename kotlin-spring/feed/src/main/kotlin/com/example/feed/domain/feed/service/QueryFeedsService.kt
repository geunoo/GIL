package com.example.feed.domain.feed.service

import com.example.feed.domain.feed.domain.repository.FeedRepository
import com.example.feed.domain.feed.presentation.dto.response.QueryFeedsResponse
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class QueryFeedsService(
    private val feedRepository: FeedRepository,
) {

    @Transactional(readOnly = true)
    fun execute(): List<QueryFeedsResponse> {
        return feedRepository.queryFeeds()
    }
}