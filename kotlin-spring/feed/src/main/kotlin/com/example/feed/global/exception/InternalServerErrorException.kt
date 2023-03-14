package com.example.feed.global.exception

import com.example.feed.global.error.exception.ErrorCode
import com.example.feed.global.error.exception.CustomException

object InternalServerErrorException : CustomException(
        ErrorCode.INTERNAL_SERVER_ERROR
)