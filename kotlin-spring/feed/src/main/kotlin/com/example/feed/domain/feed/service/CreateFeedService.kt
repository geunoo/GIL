package com.example.feed.domain.feed.service

import com.example.feed.domain.feed.domain.Feed
import com.example.feed.domain.feed.domain.repository.FeedRepository
import com.example.feed.domain.feed.presentation.dto.request.CreateFeedRequest
import com.example.feed.domain.user.domain.User
import com.example.feed.domain.user.facade.UserFacade
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CreateFeedService(
    private val feedRepository: FeedRepository,
    private val userFacade: UserFacade,
) {

    @Transactional
    fun execute(request: CreateFeedRequest) {
        val user: User = userFacade.getCurrentUser()

        feedRepository.saveFeed(
            Feed(
                title = request.title,
                content = request.content,
                user = user
            )
        )
    }
}
