package com.example.crud.service

import com.example.crud.controller.dto.response.QueryFeedsResponse
import com.example.crud.repository.FeedRepository
import org.springframework.stereotype.Service

@Service
class QueryFeedsService(
        private val feedRepository: FeedRepository,
) {

    fun execute(): List<QueryFeedsResponse> {
        return feedRepository.findAllByOrderByIdDesc().stream()
                .map {
                    QueryFeedsResponse(
                            feedId = it.id,
                            title = it.title,
                            content = it.content
                    )
                }.toList()
    }
}