package com.example.crud.event;

import com.example.crud.SOUTService;
import com.example.crud.entity.Feed;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class FeedEntityListener {

    @Lazy
    private final SOUTService soutService;

    public void postUpdate(Feed feed) {
        soutService.sout();
    }
}
