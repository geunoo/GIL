package com.example.hexagonalfeed.domain.feed.spi;

import com.example.hexagonalfeed.domain.feed.domain.Feed;

import java.util.List;
import java.util.UUID;

public interface FeedQuerySpi {

    List<Feed> queryFeeds();
    Feed queryFeedById(UUID feedId);

}
