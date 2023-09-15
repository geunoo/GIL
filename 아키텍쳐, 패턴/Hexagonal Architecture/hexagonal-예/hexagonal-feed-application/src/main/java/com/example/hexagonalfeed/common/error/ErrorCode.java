package com.example.hexagonalfeed.common.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    INTERNAL_SERVER_ERROR(500, "Internal Server Error"),

    FEED_NOT_FOUND(404, "Feed Not Found");

    private final Integer status;
    private final String message;
}
