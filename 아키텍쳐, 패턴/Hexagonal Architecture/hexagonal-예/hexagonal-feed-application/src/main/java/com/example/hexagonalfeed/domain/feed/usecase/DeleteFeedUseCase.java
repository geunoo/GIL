package com.example.hexagonalfeed.domain.feed.usecase;

import com.example.hexagonalfeed.common.annotation.UseCase;
import com.example.hexagonalfeed.domain.feed.api.DeleteFeedApi;
import com.example.hexagonalfeed.domain.feed.domain.Feed;
import com.example.hexagonalfeed.domain.feed.spi.FeedSpi;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
@UseCase
public class DeleteFeedUseCase implements DeleteFeedApi {

    private final FeedSpi feedSpi;

    @Override
    public void execute(UUID feedId) {
        Feed feed = feedSpi.queryFeedById(feedId);
        feedSpi.delete(feed);
    }
}
