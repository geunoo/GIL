package com.example.feed.domain.user.service

import com.example.feed.domain.user.domain.User
import com.example.feed.domain.user.domain.repository.UserRepository
import com.example.feed.domain.user.exception.InvalidPasswordException
import com.example.feed.domain.user.presentation.dto.request.SignInRequest
import com.example.feed.domain.user.presentation.dto.response.TokenResponse
import com.example.feed.global.security.jwt.JwtTokenProvider
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class SignInService(
        private val userRepository: UserRepository,
        private val jwtTokenProvider: JwtTokenProvider,
        private val passwordEncoder: PasswordEncoder,
) {

    @Transactional
    fun execute(request: SignInRequest): TokenResponse {

        val user: User = userRepository.queryUserByAccountId(request.accountId)

        if (!passwordEncoder.matches(request.password, user.password)) {
            throw InvalidPasswordException
        }

        val accessToken = jwtTokenProvider.generateAccessToken(user.accountId)
        val refreshToken = jwtTokenProvider.generateRefreshToken(user.accountId)

        return TokenResponse(
            accessToken = accessToken,
            refreshToken = refreshToken,
        )
    }
}