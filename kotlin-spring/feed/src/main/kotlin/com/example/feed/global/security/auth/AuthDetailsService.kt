package com.example.feed.global.security.auth

import com.example.feed.domain.user.domain.repository.UserRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Component

@Component
class AuthDetailsService(
        private val userRepository: UserRepository,
): UserDetailsService {

    override fun loadUserByUsername(accountId: String): UserDetails {
        val user = userRepository.queryUserByAccountId(accountId)

        return AuthDetails(user)
    }
}