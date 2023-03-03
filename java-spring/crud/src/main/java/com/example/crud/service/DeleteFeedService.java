package com.example.crud.service;

import com.example.crud.entity.Feed;
import com.example.crud.repository.FeedRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class DeleteFeedService {

    private final FeedRepository feedRepository;

    @Transactional
    public void execute(Long feedId) {

        Feed feed = feedRepository.findById(feedId)
                .orElseThrow(RuntimeException::new);

        feedRepository.delete(feed);
    }
}
