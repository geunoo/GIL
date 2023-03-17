package com.example.feed.domain.user.service

import com.example.feed.domain.user.domain.User
import com.example.feed.domain.user.domain.repository.UserRepository
import com.example.feed.domain.user.exception.UserAlreadyExistsException
import com.example.feed.domain.user.presentation.dto.request.SignUpRequest
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class SignUpService(
        private val userRepository: UserRepository,
        private val passwordEncoder: PasswordEncoder,
) {

    @Transactional
    fun execute(request: SignUpRequest) {

        if (userRepository.existsUserByAccountId(request.accountId)) {
            throw UserAlreadyExistsException
        }

        userRepository.saveUser(
                User(
                        accountId = request.accountId,
                        password = passwordEncoder.encode(request.password),
                        name = request.name,
                        birthday = request.birthday,
                        sex = request.sex
                )
        )
    }
}