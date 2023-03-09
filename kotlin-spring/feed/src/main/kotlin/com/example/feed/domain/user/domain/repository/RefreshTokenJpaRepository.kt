package com.example.feed.domain.user.domain.repository

import com.example.feed.domain.user.domain.RefreshToken
import org.springframework.data.jpa.repository.JpaRepository

interface RefreshTokenJpaRepository : JpaRepository<RefreshToken, String> {
}