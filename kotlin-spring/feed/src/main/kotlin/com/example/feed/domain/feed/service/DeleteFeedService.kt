package com.example.feed.domain.feed.service

import com.example.feed.domain.feed.domain.repository.FeedRepository
import com.example.feed.domain.feed.exception.FeedNotFoundException
import com.example.feed.domain.feed.exception.UserMismatchException
import com.example.feed.domain.user.facade.UserFacade
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.UUID

@Service
class DeleteFeedService(

    private val feedRepository: FeedRepository,
    private val userFacade: UserFacade,
) {

    @Transactional
    fun execute(feedId: UUID) {

        val user = userFacade.getCurrentUser()
        val feed = feedRepository.queryFeedById(feedId) ?: throw FeedNotFoundException

        if (user != feed.user) {
            throw UserMismatchException
        }

        feedRepository.deleteFeed(feed)
    }
}