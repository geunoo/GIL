package com.example.feed.domain.user.domain.repository

import com.example.feed.domain.user.domain.User
import com.example.feed.domain.user.exception.UserNotFoundException
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class UserRepository(
        private val userJpaRepository: UserJpaRepository,
) {

    fun queryUserById(id: UUID?): User =
            userJpaRepository.findByIdOrNull(id) ?: throw UserNotFoundException

    fun queryUserByAccountId(accountId: String): User =
            userJpaRepository.findByAccountId(accountId) ?: throw UserNotFoundException

    fun existsUserByAccountId(accountId: String): Boolean =
            userJpaRepository.existsByAccountId(accountId)

    fun saveUser(user: User): User =
            userJpaRepository.save(user)
}