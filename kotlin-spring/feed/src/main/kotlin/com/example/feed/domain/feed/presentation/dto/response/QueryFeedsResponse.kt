package com.example.feed.domain.feed.presentation.dto.response

import com.fasterxml.jackson.annotation.JsonFormat
import com.querydsl.core.annotations.QueryProjection
import java.time.LocalDateTime
import java.util.UUID

data class QueryFeedsResponse @QueryProjection constructor(

    val feedId: UUID,
    val title: String,
    val content: String,
    val username: String,

    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss", timezone = "Asia/Seoul")
    val createdAt: LocalDateTime
)
