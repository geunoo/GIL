package com.example.crud.event;

import com.example.crud.entity.Feed;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class FeedEventListener {

    @EventListener
    public void onCreateFeedEvent(Feed feed) {
        System.out.println(feed.getTitle() + " : " + feed.getContent());
    }
}
