package com.example.hexagonalfeed.domain.feed.usecase;

import com.example.hexagonalfeed.common.annotation.ReadOnlyUseCase;
import com.example.hexagonalfeed.domain.feed.api.QueryFeedsApi;
import com.example.hexagonalfeed.domain.feed.dto.response.DomainQueryFeedResponse;
import com.example.hexagonalfeed.domain.feed.spi.FeedQuerySpi;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@ReadOnlyUseCase
public class QueryFeedsUseCase implements QueryFeedsApi {

    private final FeedQuerySpi feedQuerySpi;

    @Override
    public List<DomainQueryFeedResponse> execute() {
        return feedQuerySpi.queryFeeds().stream()
                .map(feed -> DomainQueryFeedResponse.builder()
                        .feedId(feed.getId())
                        .title(feed.getTitle())
                        .content(feed.getContent())
                        .createdAt(feed.getCreatedAt())
                        .build())
                .toList();
    }
}
