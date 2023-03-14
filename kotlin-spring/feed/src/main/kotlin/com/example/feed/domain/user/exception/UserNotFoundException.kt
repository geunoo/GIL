package com.example.feed.domain.user.exception

import com.example.feed.global.error.exception.ErrorCode
import com.example.feed.global.error.exception.CustomException

object UserNotFoundException: CustomException(
        ErrorCode.USER_NOT_FOUND
)