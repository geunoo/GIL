package com.example.feed.global.error

enum class ErrorCode(
        override val status: Int,
        override val message: String
): ErrorResponse {

    USER_NOT_FOUND(404, "User Not Found"),

    INTERNAL_SERVER_ERROR(500, "Internal Server Error")
}