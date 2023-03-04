package com.example.crud.service

import com.example.crud.controller.dto.request.CreateFeedRequest
import com.example.crud.entity.Feed
import com.example.crud.repository.FeedRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CreateFeedService(
        private val feedRepository: FeedRepository
) {

    @Transactional
    fun execute(request: CreateFeedRequest) {

        feedRepository.save(
                Feed(
                        title = request.title,
                        content = request.content,
                )
        )
    }
}