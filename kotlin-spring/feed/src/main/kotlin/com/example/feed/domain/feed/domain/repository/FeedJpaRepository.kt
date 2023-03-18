package com.example.feed.domain.feed.domain.repository

import com.example.feed.domain.feed.domain.Feed
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface FeedJpaRepository : JpaRepository<Feed, UUID>{
}