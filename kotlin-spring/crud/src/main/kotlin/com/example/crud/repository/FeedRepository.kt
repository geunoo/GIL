package com.example.crud.repository

import com.example.crud.entity.Feed
import org.springframework.data.jpa.repository.JpaRepository

interface FeedRepository : JpaRepository<Feed, Long> {

    fun findAllByOrderByIdDesc(): List<Feed>
}