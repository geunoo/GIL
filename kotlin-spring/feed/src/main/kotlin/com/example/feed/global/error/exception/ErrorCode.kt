package com.example.feed.global.error.exception

import com.example.feed.global.error.ErrorResponse

enum class ErrorCode(
        override val status: Int,
        override val message: String
): ErrorResponse {

    EXPIRED_TOKEN(401,"Token Expired" ),
    INVALID_TOKEN(401,"Invalid Token"),

    USER_NOT_FOUND(404, "User Not Found"),

    INTERNAL_SERVER_ERROR(500, "Internal Server Error")
}