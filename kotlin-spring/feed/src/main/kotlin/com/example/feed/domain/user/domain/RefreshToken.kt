package com.example.feed.domain.user.domain

import org.springframework.data.annotation.Id
import org.springframework.data.redis.core.RedisHash
import org.springframework.data.redis.core.TimeToLive
import org.springframework.data.redis.core.index.Indexed

@RedisHash
class RefreshToken(

        @Id
        val accountId: String,
        token: String,
        ttl: Long
) {

        @Indexed
        var token: String = token
                private set

        @TimeToLive
        var ttl: Long = ttl
                private set

        fun update(token: String, ttl: Long) {
                this.token = token
                this.ttl = ttl
        }
}