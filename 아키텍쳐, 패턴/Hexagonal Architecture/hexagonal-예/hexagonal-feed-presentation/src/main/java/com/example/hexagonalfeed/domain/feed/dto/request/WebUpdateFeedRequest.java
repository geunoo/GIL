package com.example.hexagonalfeed.domain.feed.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor
public class WebUpdateFeedRequest {

    @NotBlank
    private String title;

    @NotBlank
    private String content;
}
