package com.example.feed.domain.user.exception

import com.example.feed.global.error.exception.CustomException
import com.example.feed.global.error.exception.ErrorCode

object InvalidPasswordException: CustomException(
    ErrorCode.INVALID_PASSWORD
) {
}