package com.example.feed.domain.feed.service

import com.example.feed.domain.feed.domain.Feed
import com.example.feed.domain.feed.domain.repository.FeedRepository
import com.example.feed.domain.feed.exception.FeedNotFoundException
import com.example.feed.domain.feed.exception.UserMismatchException
import com.example.feed.domain.feed.presentation.dto.request.UpdateFeedRequest
import com.example.feed.domain.user.domain.User
import com.example.feed.domain.user.facade.UserFacade
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.UUID

@Service
class UpdateFeedService(
    private val feedRepository: FeedRepository,
    private val userFacade: UserFacade,
) {

    @Transactional
    fun execute(id: UUID, request: UpdateFeedRequest) {

        val user: User = userFacade.getCurrentUser()
        val feed: Feed = feedRepository.queryFeedById(id)
            ?: throw FeedNotFoundException

        if (user != feed.user) {
            throw UserMismatchException
        }

        feed.update(request.title, request.content)
    }
}