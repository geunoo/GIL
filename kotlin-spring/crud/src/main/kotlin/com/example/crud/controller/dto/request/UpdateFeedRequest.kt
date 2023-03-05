package com.example.crud.controller.dto.request

import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

data class UpdateFeedRequest(

        @field:NotBlank
        @field:Size(min = 1, max = 10, message = "title은 1~10자여야 합니다.")
        val title: String,

        @field:NotBlank
        @field:Size(min = 1, max = 1000, message = "content는 1~1000자여야 합니다.")
        val content: String,
)
