package com.example.hexagonalfeed.domain.feed.spi;

import com.example.hexagonalfeed.domain.feed.domain.Feed;

import java.util.List;

public interface FeedQuerySpi {

    List<Feed> queryFeeds();
}
