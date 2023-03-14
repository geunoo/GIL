package com.example.feed.global.security.jwt

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConstructorBinding
@ConfigurationProperties(prefix = "jwt")
class JwtProperties (
    val secret: String,
    val header: String,
    val prefix: String,
    val accessExp: Long,
    val refreshExp: Long,
)