package com.example.feed.domain.user.domain.repository

import com.example.feed.domain.user.domain.RefreshToken
import org.springframework.data.repository.CrudRepository

interface RefreshTokenJpaRepository : CrudRepository<RefreshToken, String> {

    fun queryByToken(token: String): RefreshToken?
}