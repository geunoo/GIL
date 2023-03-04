package com.example.crud.controller.dto.response

data class QueryFeedsResponse(
        val feedId: Long,
        val title: String,
        val content: String,
)