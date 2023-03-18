package com.example.feed.domain.feed.presentation.dto.response

import com.fasterxml.jackson.annotation.JsonFormat
import java.time.LocalDateTime

data class QueryFeedsResponse(

    val title: String,
    val content: String,

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-mm-dd HH:MM:ss")
    val createdAt: LocalDateTime
)
