package com.example.feed.global.error

import com.example.feed.global.error.exception.CustomException

data class BaseErrorResponse(

        val status: Int,
        val message: String,
) {

    companion object {
        fun of(e: CustomException): BaseErrorResponse {
            return BaseErrorResponse(
                    status = e.status,
                    message = e.message,
            )
        }
    }
}