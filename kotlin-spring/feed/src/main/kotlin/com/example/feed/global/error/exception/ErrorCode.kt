package com.example.feed.global.error.exception

import com.example.feed.global.error.response.ErrorResponse

enum class ErrorCode(
        override val status: Int,
        override val message: String
): ErrorResponse {

    EXPIRED_TOKEN(401,"Token Expired" ),
    INVALID_TOKEN(401,"Invalid Token"),
    INVALID_PASSWORD(401, "Invalid Password"),

    USER_MISMATCH(403, "User Mismatch"),

    USER_NOT_FOUND(404, "User Not Found"),
    FEED_NOT_FOUND(404, "Feed Not Found"),

    USER_ALREADY_EXISTS(409, "User Already Exists"),

    INTERNAL_SERVER_ERROR(500, "Internal Server Error")
}