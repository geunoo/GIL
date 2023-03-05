package com.example.crud.controller

import com.example.crud.controller.dto.request.CreateFeedRequest
import com.example.crud.controller.dto.request.UpdateFeedRequest
import com.example.crud.controller.dto.response.QueryFeedsResponse
import com.example.crud.service.CreateFeedService
import com.example.crud.service.QueryFeedsService
import com.example.crud.service.UpdateFeedService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RequestMapping("/feeds")
@RestController
class FeedController(
        private val createFeedService: CreateFeedService,
        private val queryFeedsService: QueryFeedsService,
        private val updateFeedService: UpdateFeedService,
) {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    fun createFeed(@RequestBody @Valid request: CreateFeedRequest) {
        createFeedService.execute(request)
    }

    @GetMapping
    fun queryFeeds(): List<QueryFeedsResponse> {
        return queryFeedsService.execute()
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{feed-id}")
    fun updateFeed(@PathVariable("feed-id") id: Long, @RequestBody @Valid request: UpdateFeedRequest) {
        updateFeedService.execute(id, request)
    }
}