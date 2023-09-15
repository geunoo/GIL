package com.example.hexagonalfeed.domain.feed.api;

import com.example.hexagonalfeed.domain.feed.dto.response.DomainQueryFeedResponse;

import java.util.List;

public interface QueryFeedsApi {

    List<DomainQueryFeedResponse> execute();
}
