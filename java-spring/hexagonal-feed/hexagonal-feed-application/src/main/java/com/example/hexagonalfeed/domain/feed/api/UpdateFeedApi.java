package com.example.hexagonalfeed.domain.feed.api;

import com.example.hexagonalfeed.domain.feed.dto.request.DomainUpdateFeedRequest;

import java.util.UUID;

public interface UpdateFeedApi {

    void execute(UUID feedId, DomainUpdateFeedRequest request);
}
