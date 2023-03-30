package com.example.feed.domain.feed.exception

import com.example.feed.global.error.exception.CustomException
import com.example.feed.global.error.exception.ErrorCode

object FeedNotFoundException : CustomException(
    ErrorCode.FEED_NOT_FOUND
)