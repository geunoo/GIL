package com.example.hexagonalfeed.domain.feed;

import com.example.hexagonalfeed.domain.feed.api.CreateFeedApi;
import com.example.hexagonalfeed.domain.feed.dto.request.DomainCreateFeedRequest;
import com.example.hexagonalfeed.domain.feed.dto.request.WebCreateFeedRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RequestMapping("/feeds")
@RestController
public class FeedWebAdapter {

    private final CreateFeedApi createFeedApi;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void createFeed(
            @RequestBody @Valid WebCreateFeedRequest request
    ) {
        createFeedApi.execute(
                DomainCreateFeedRequest.builder()
                        .title(request.getTitle())
                        .content(request.getContent())
                        .build()
        );
    }
}
