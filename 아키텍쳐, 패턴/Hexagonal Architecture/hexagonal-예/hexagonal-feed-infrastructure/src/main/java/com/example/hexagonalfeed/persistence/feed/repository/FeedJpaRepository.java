package com.example.hexagonalfeed.persistence.feed.repository;

import com.example.hexagonalfeed.persistence.feed.entity.FeedJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FeedJpaRepository extends JpaRepository<FeedJpaEntity, UUID> {
}
