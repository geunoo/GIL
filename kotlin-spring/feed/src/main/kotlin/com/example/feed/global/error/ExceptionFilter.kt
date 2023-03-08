package com.example.feed.global.error

import com.example.feed.global.error.exception.CustomException
import com.example.feed.global.exception.InternalServerErrorException
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.http.MediaType
import org.springframework.web.filter.OncePerRequestFilter
import java.nio.charset.StandardCharsets
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class ExceptionFilter(
        private val objectMapper: ObjectMapper,
): OncePerRequestFilter() {
    override fun doFilterInternal(
            request: HttpServletRequest,
            response: HttpServletResponse,
            filterChain: FilterChain) {
        try {
            filterChain.doFilter(request, response)
        } catch (e: Exception) {
            when(e) {
                is CustomException -> sendErrorMessage(e, response)
                else -> sendErrorMessage(InternalServerErrorException, response)
            }

        }
    }

    private fun sendErrorMessage(exception: CustomException, response: HttpServletResponse) {
        val error = BaseErrorResponse.of(exception)

        response.status = error.status
        response.contentType = MediaType.APPLICATION_JSON_VALUE
        response.characterEncoding = StandardCharsets.UTF_8.toString()
        objectMapper.writeValue(response.writer, error)
    }

}