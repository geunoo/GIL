package com.example.feed.domain.user.domain.repository

import com.example.feed.domain.user.domain.User
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface UserJpaRepository: JpaRepository<User, UUID> {

    fun findByAccountId(accountId: String): User?
    fun existsByAccountId(accountId: String): Boolean
}