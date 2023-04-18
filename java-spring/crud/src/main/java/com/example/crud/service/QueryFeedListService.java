package com.example.crud.service;

import com.example.crud.controller.dto.response.QueryFeedListResponse;
import com.example.crud.controller.dto.response.QueryFeedListResponse.QueryFeedResponse;
import com.example.crud.repository.FeedRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class QueryFeedListService {

    private final FeedRepository feedRepository;

    @Transactional(readOnly = true)
    public QueryFeedListResponse execute() {
        return new QueryFeedListResponse(feedRepository.findAllByOrderByIdDesc().stream()
                .map(feed -> QueryFeedResponse.builder()
                        .id(feed.getId())
                        .title(feed.getTitle())
                        .content(feed.getContent())
                        .build())
                .toList());
    }
}
