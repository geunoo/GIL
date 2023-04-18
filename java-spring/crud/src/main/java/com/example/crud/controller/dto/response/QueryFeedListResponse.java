package com.example.crud.controller.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class QueryFeedListResponse {

    private final List<QueryFeedResponse> queryFeedResponses;

    @Getter
    @Builder
    public static class QueryFeedResponse {
        private final Long id;
        private final String title;
        private final String content;
    }
}
