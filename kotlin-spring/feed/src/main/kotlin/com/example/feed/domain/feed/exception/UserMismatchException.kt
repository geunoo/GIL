package com.example.feed.domain.feed.exception

import com.example.feed.global.error.exception.CustomException
import com.example.feed.global.error.exception.ErrorCode

object UserMismatchException : CustomException(
    ErrorCode.USER_MISMATCH
)