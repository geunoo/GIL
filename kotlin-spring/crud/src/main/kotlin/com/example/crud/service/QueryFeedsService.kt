package com.example.crud.service

import com.example.crud.controller.dto.response.QueryFeedsResponse
import com.example.crud.repository.FeedRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class QueryFeedsService(
        private val feedRepository: FeedRepository,
) {

    @Transactional(readOnly = true)
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