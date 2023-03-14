package com.example.feed.global.exception

import com.example.feed.global.error.exception.CustomException
import com.example.feed.global.error.exception.ErrorCode

object ExpiredTokenException : CustomException(
        ErrorCode.EXPIRED_TOKEN
) {
}