package com.example.crud.repository;

import com.example.crud.entity.Feed;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FeedRepository extends JpaRepository<Feed, Long> {

    List<Feed> findAllByOrderByIdDesc();
}
