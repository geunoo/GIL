package com.example.feed.domain.user.exception

import com.example.feed.global.error.exception.CustomException
import com.example.feed.global.error.exception.ErrorCode

object UserAlreadyExistsException: CustomException(
        ErrorCode.USER_ALREADY_EXISTS
)