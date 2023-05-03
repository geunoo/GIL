package com.example.hexagonalfeed.domain.feed.usecase;

import com.example.hexagonalfeed.common.annotation.UseCase;
import com.example.hexagonalfeed.domain.feed.api.CreateFeedApi;
import com.example.hexagonalfeed.domain.feed.domain.Feed;
import com.example.hexagonalfeed.domain.feed.dto.request.DomainCreateFeedRequest;
import com.example.hexagonalfeed.domain.feed.spi.FeedCommandSpi;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@UseCase
public class CreateFeedUseCase implements CreateFeedApi {

    private final FeedCommandSpi feedCommandSpi;

    @Override
    public void execute(DomainCreateFeedRequest request) {
        feedCommandSpi.save(Feed.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .build()
        );
    }
}
