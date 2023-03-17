package com.example.feed.domain.user.presentation.dto.request

import com.example.feed.domain.user.domain.enums.Sex
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

data class SignUpRequest(

        @NotBlank
        val accountId: String,

        @NotBlank
        val password: String,

        @NotBlank
        val name: String,

        @NotBlank
        val birthday: String,

        @NotNull
        val sex: Sex,
)
