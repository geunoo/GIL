package com.example.crud.service;

import com.example.crud.controller.dto.response.QueryFeedListResponse;
import com.example.crud.entity.Feed;
import com.example.crud.repository.FeedRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class QueryFeedListService {

    private final FeedRepository feedRepository;

    public List<QueryFeedListResponse> execute() {
        return feedRepository.findAllByOrderByIdDesc().stream()
                .map(feed -> new QueryFeedListResponse(feed.getTitle(), feed.getContent()))
                .toList();
    }
}
