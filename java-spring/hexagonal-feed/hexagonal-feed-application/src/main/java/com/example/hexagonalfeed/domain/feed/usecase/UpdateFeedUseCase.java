package com.example.hexagonalfeed.domain.feed.usecase;

import com.example.hexagonalfeed.common.annotation.UseCase;
import com.example.hexagonalfeed.domain.feed.api.UpdateFeedApi;
import com.example.hexagonalfeed.domain.feed.domain.Feed;
import com.example.hexagonalfeed.domain.feed.dto.request.DomainUpdateFeedRequest;
import com.example.hexagonalfeed.domain.feed.spi.FeedSpi;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
@UseCase
public class UpdateFeedUseCase implements UpdateFeedApi {

    private final FeedSpi feedSpi;

    @Override
    public void execute(UUID feedId, DomainUpdateFeedRequest request) {
        Feed feed = feedSpi.queryFeedById(feedId);

        feedSpi.save(
                feed.update(
                        request.getTitle(),
                        request.getContent()
                )
        );
    }
}
