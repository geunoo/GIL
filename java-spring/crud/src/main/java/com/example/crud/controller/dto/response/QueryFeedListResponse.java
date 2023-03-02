package com.example.crud.controller.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class QueryFeedListResponse {

    private final String title;
    private final String content;
}
