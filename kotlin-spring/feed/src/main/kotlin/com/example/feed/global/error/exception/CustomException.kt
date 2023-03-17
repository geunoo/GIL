package com.example.feed.global.error.exception

import com.example.feed.global.error.response.ErrorResponse

abstract class CustomException(
        private val error: ErrorResponse
): RuntimeException() {

    val status: Int
        get() = error.status

    override val message: String
        get() = error.message
}