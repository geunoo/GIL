package com.example.hexagonalfeed.domain.feed;

import com.example.hexagonalfeed.domain.feed.api.CreateFeedApi;
import com.example.hexagonalfeed.domain.feed.api.DeleteFeedApi;
import com.example.hexagonalfeed.domain.feed.api.QueryFeedsApi;
import com.example.hexagonalfeed.domain.feed.api.UpdateFeedApi;
import com.example.hexagonalfeed.domain.feed.dto.request.DomainCreateFeedRequest;
import com.example.hexagonalfeed.domain.feed.dto.request.DomainUpdateFeedRequest;
import com.example.hexagonalfeed.domain.feed.dto.request.WebUpdateFeedRequest;
import com.example.hexagonalfeed.domain.feed.dto.response.WebQueryFeedsResponse;
import com.example.hexagonalfeed.domain.feed.dto.request.WebCreateFeedRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.UUID;

@RequiredArgsConstructor
@RequestMapping("/feeds")
@RestController
public class FeedWebAdapter {

    private final CreateFeedApi createFeedApi;
    private final QueryFeedsApi queryFeedsApi;
    private final UpdateFeedApi updateFeedApi;
    private final DeleteFeedApi deleteFeedApi;

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

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{feed-id}")
    public void updateFeed(
            @PathVariable("feed-id") UUID feedId,
            @RequestBody @Valid WebUpdateFeedRequest request
    ) {
        updateFeedApi.execute(
                feedId,
                DomainUpdateFeedRequest.builder()
                        .title(request.getTitle())
                        .content(request.getContent())
                        .build()
        );

    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{feed-id}")
    public void deleteFeed(
            @PathVariable("feed-id") UUID feedId
    ) {
        deleteFeedApi.execute(
                feedId
        );
    }
}
