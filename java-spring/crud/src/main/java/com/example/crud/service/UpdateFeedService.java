package com.example.crud.service;

import com.example.crud.controller.dto.request.UpdateFeedRequest;
import com.example.crud.entity.Feed;
import com.example.crud.repository.FeedRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UpdateFeedService {

    private final FeedRepository feedRepository;

    @Transactional
    public void execute(Long id, UpdateFeedRequest request) {

        Feed feed = feedRepository.findById(id)
                .orElseThrow(RuntimeException::new);

        feed.update(request.getTitle(), request.getContent());
    }
}
