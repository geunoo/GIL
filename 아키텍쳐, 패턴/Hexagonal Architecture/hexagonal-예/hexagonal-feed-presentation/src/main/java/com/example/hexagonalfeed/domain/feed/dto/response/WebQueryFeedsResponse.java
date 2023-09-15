package com.example.hexagonalfeed.domain.feed.dto.response;

import com.example.hexagonalfeed.domain.feed.dto.response.DomainQueryFeedResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class WebQueryFeedsResponse {

    private final List<DomainQueryFeedResponse> feeds;
}
