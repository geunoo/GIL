package com.example.hexagonalfeed.domain.feed.api;

import java.util.UUID;

public interface DeleteFeedApi {

    void execute(UUID feedId);
}
