package com.example.crud.controller;

import com.example.crud.controller.dto.request.CreateFeedRequest;
import com.example.crud.controller.dto.response.QueryFeedListResponse;
import com.example.crud.service.CreateFeedService;
import com.example.crud.service.QueryFeedListService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/feed")
@RestController
public class FeedController {

    private final CreateFeedService createFeedService;
    private final QueryFeedListService queryFeedListService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void createFeed(@RequestBody @Valid CreateFeedRequest request) {
        createFeedService.execute(request);
    }

    @GetMapping
    public List<QueryFeedListResponse> queryFeedList() {
        return queryFeedListService.execute();
    }
}
