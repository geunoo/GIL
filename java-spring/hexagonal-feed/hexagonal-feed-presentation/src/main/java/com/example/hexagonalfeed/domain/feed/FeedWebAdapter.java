package com.example.hexagonalfeed.domain.feed;

import com.example.hexagonalfeed.domain.feed.api.CreateFeedApi;
import com.example.hexagonalfeed.domain.feed.api.QueryFeedsApi;
import com.example.hexagonalfeed.domain.feed.dto.request.DomainCreateFeedRequest;
import com.example.hexagonalfeed.domain.feed.dto.response.WebQueryFeedsResponse;
import com.example.hexagonalfeed.domain.feed.dto.request.WebCreateFeedRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/feeds")
@RestController
public class FeedWebAdapter {

    private final CreateFeedApi createFeedApi;
    private final QueryFeedsApi queryFeedsApi;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void createFeed(
            @RequestBody WebCreateFeedRequest request
    ) {
        createFeedApi.execute(
                DomainCreateFeedRequest.builder()
                        .title(request.getTitle())
                        .content(request.getContent())
                        .build()
        );
    }

    @GetMapping
    public WebQueryFeedsResponse queryFeeds() {
        return new WebQueryFeedsResponse(
                queryFeedsApi.execute()
        );
    }
}
