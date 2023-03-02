package com.example.crud.service;

import com.example.crud.controller.dto.response.QueryFeedListResponse;
import com.example.crud.entity.Feed;
import com.example.crud.repository.FeedRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class QueryFeedListService {

    private final FeedRepository feedRepository;

    @Transactional(readOnly = true)
    public List<QueryFeedListResponse> execute() {
        return feedRepository.findAllByOrderByIdDesc().stream()
                .map(feed -> new QueryFeedListResponse(feed.getId(), feed.getTitle(), feed.getContent()))
                .toList();
    }
}
