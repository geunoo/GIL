package com.example.feed.domain.user.domain

import org.springframework.data.annotation.Id
import org.springframework.data.redis.core.RedisHash
import org.springframework.data.redis.core.TimeToLive
import org.springframework.data.redis.core.index.Indexed

@RedisHash
class RefreshToken(

        @Id
        val accountId: String,

        @Indexed
        val token: String,

        @TimeToLive
        val ttl: Long
)