package com.example.feed.domain.user.exception

import com.example.feed.global.error.ErrorCode
import com.example.feed.global.error.exception.CustomException

object UserNotFoundException: CustomException(
        ErrorCode.USER_NOT_FOUND
)