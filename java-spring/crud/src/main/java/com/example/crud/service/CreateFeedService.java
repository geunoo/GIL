package com.example.crud.service;

import com.example.crud.controller.dto.request.CreateFeedRequest;
import com.example.crud.entity.Feed;
import com.example.crud.repository.FeedRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class CreateFeedService {

    private final FeedRepository feedRepository;

    @Transactional
    public void execute(CreateFeedRequest request) {
        feedRepository.save(Feed.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .build()
        );
    }
}
