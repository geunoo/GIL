package com.example.feed.domain.user.presentation

import com.example.feed.domain.user.presentation.dto.request.SignUpRequest
import com.example.feed.domain.user.service.SignUpService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RequestMapping("/users")
@RestController
class UserController(
        private val signUpService: SignUpService,
) {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/signup")
    fun signup(@RequestBody @Valid request: SignUpRequest) =
            signUpService.execute(request)
}