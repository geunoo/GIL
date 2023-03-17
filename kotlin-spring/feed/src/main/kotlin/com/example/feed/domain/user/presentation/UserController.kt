package com.example.feed.domain.user.presentation

import com.example.feed.domain.user.presentation.dto.request.SignInRequest
import com.example.feed.domain.user.presentation.dto.request.SignUpRequest
import com.example.feed.domain.user.presentation.dto.response.TokenResponse
import com.example.feed.domain.user.service.SignInService
import com.example.feed.domain.user.service.SignUpService
import com.example.feed.domain.user.service.TokenReissueService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RequestMapping("/users")
@RestController
class UserController(
        private val signUpService: SignUpService,
        private val signInService: SignInService,
        private val tokenReissueService: TokenReissueService,
) {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/signup")
    fun signup(@RequestBody @Valid request: SignUpRequest) =
            signUpService.execute(request)

    @PostMapping("/login")
    fun login(@RequestBody @Valid request: SignInRequest) =
        signInService.execute(request)

    @PutMapping("/reissue")
    fun reissue(@RequestHeader("x-refresh-token") token: String): TokenResponse =
        tokenReissueService.execute(token)
}