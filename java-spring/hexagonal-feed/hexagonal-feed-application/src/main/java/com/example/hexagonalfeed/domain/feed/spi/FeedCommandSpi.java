package com.example.hexagonalfeed.domain.feed.spi;

import com.example.hexagonalfeed.domain.feed.domain.Feed;

public interface FeedCommandSpi {

    Feed save(Feed feed);

    void delete(Feed feed);
}
