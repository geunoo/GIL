package com.example.feed.domain.user.service

import com.example.feed.domain.user.domain.RefreshToken
import com.example.feed.domain.user.domain.repository.RefreshTokenJpaRepository
import com.example.feed.domain.user.presentation.dto.response.TokenResponse
import com.example.feed.global.exception.InvalidTokenException
import com.example.feed.global.security.jwt.JwtProperties
import com.example.feed.global.security.jwt.JwtTokenProvider
import org.springframework.stereotype.Service

@Service
class TokenReissueService(
    private val refreshTokenJpaRepository: RefreshTokenJpaRepository,
    private val jwtTokenProvider: JwtTokenProvider,
    private val jwtProperties: JwtProperties,
) {

    fun execute(token: String): TokenResponse {

        val refreshToken: RefreshToken =  refreshTokenJpaRepository.queryByToken(token)
            ?: throw InvalidTokenException

        val newAccessToken: String = jwtTokenProvider.generateAccessToken(refreshToken.accountId)
        val newRefreshToken: String = jwtTokenProvider.generateRefreshToken(refreshToken.accountId)
        refreshToken.update(newRefreshToken, jwtProperties.refreshExp)

        return TokenResponse(
            accessToken = newAccessToken,
            refreshToken = newRefreshToken,
        )
    }
}