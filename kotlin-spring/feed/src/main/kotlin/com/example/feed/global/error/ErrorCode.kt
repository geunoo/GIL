package com.example.feed.global.error

enum class ErrorCode(
        override val status: Int,
        override val message: String
): ErrorResponse {

    INTERNAL_SERVER_ERROR(500, "Internal Server Error")
}