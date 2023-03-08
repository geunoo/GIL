package com.example.feed.global.error

import com.example.feed.global.error.exception.CustomException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ExceptionHandler {

    @ExceptionHandler(CustomException::class)
    fun customException(e: CustomException): ResponseEntity<BaseErrorResponse> {
        return ResponseEntity(
                BaseErrorResponse.of(e),
                HttpStatus.valueOf(e.status)
        )
    }
}