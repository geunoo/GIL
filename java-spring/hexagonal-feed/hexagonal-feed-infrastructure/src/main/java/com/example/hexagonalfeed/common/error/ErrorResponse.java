package com.example.hexagonalfeed.common.error;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ErrorResponse {

    private final Integer status;
    private final String message;
}
