package com.example.feed.global.security

import com.example.feed.global.error.ExceptionFilter
import com.example.feed.global.security.jwt.JwtFilter
import com.example.feed.global.security.jwt.JwtTokenProvider
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.security.config.annotation.SecurityConfigurerAdapter
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.web.DefaultSecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter

class FilterConfig(
        private val jwtTokenProvider: JwtTokenProvider,
        private val objectMapper: ObjectMapper,
) : SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity>() {

    override fun configure(http: HttpSecurity) {
        val exceptionFilter = ExceptionFilter(objectMapper)
        val jwtFilter = JwtFilter(jwtTokenProvider)
        http
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter::class.java)
                .addFilterBefore(exceptionFilter, jwtFilter::class.java)
    }
}