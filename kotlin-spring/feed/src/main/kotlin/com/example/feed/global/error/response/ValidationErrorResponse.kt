package com.example.feed.global.error.response

data class ValidationErrorResponse(

        val status: Int,
        val error: HashMap<String, String?>
)
