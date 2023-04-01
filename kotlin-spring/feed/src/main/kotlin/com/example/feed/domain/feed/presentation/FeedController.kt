package com.example.feed.domain.feed.presentation

import com.example.feed.domain.feed.presentation.dto.request.CreateFeedRequest
import com.example.feed.domain.feed.presentation.dto.request.UpdateFeedRequest
import com.example.feed.domain.feed.presentation.dto.response.QueryFeedsResponse
import com.example.feed.domain.feed.service.CreateFeedService
import com.example.feed.domain.feed.service.DeleteFeedService
import com.example.feed.domain.feed.service.QueryFeedsService
import com.example.feed.domain.feed.service.UpdateFeedService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import java.util.UUID
import javax.validation.Valid

@RequestMapping("/feeds")
@RestController
class FeedController(
    private val createFeedService: CreateFeedService,
    private val queryFeedsService: QueryFeedsService,
    private val updateFeedService: UpdateFeedService,
    private val deleteFeedService: DeleteFeedService,
) {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    fun create(@RequestBody @Valid request: CreateFeedRequest) =
        createFeedService.execute(request)

    @GetMapping
    fun get(): List<QueryFeedsResponse> = queryFeedsService.execute()

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{feed-id}")
    fun update(@PathVariable("feed-id") feedId: UUID, @RequestBody @Valid request: UpdateFeedRequest) {
        updateFeedService.execute(feedId, request)
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{feed-id}")
    fun delete(@PathVariable("feed-id") feedId: UUID) {
        deleteFeedService.execute(feedId)
    }
}