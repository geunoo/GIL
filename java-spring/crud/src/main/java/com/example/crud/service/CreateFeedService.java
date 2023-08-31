package com.example.crud.service;

import com.example.crud.aop.TestPrint;
import com.example.crud.controller.dto.request.CreateFeedRequest;
import com.example.crud.entity.Feed;
import com.example.crud.repository.FeedRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CreateFeedService {

    private final FeedRepository feedRepository;
    private final ApplicationEventPublisher eventPublisher;

    @TestPrint(string = "김정현봉식")
    @Transactional
    public List<Feed> execute(CreateFeedRequest request) {
        Feed feed = Feed.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .build();

        feedRepository.save(feed);
        eventPublisher.publishEvent(feed);

        return List.of(feed);
    }
}
