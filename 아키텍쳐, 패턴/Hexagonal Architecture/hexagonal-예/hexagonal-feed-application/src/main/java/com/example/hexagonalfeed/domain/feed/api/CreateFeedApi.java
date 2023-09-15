package com.example.hexagonalfeed.domain.feed.api;

import com.example.hexagonalfeed.domain.feed.dto.request.DomainCreateFeedRequest;

public interface CreateFeedApi {

    void execute(DomainCreateFeedRequest request);
}
