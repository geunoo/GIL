package com.example.feed.domain.feed.presentation.dto.request

import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

data class CreateFeedRequest(

    @NotBlank
    @Size(min = 1, max = 30)
    val title: String,

    @NotBlank
    @Size(min = 1, max = 1000)
    val content: String,
)
