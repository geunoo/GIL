package com.example.feed.global.error

import com.example.feed.global.error.exception.CustomException
import com.example.feed.global.error.response.BaseErrorResponse
import com.example.feed.global.error.response.ValidationErrorResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.FieldError
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
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

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun validException(e: MethodArgumentNotValidException): ValidationErrorResponse {
        val fieldErrors = HashMap<String, String?>()
        for (fieldError: FieldError in e.bindingResult.fieldErrors) {
            fieldErrors.put(fieldError.field, fieldError.defaultMessage)
        }

        return ValidationErrorResponse(
                status = HttpStatus.BAD_REQUEST.value(),
                error = fieldErrors
        )
    }
}