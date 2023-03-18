package com.example.feed.domain.user.facade

import com.example.feed.domain.user.domain.User
import com.example.feed.domain.user.domain.repository.UserRepository
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Component

@Component
class UserFacade(
    private val userRepository: UserRepository
) {

    fun getCurrentUser(): User {
        val accountId: String = SecurityContextHolder.getContext().authentication.name
        return userRepository.queryUserByAccountId(accountId)
    }
}