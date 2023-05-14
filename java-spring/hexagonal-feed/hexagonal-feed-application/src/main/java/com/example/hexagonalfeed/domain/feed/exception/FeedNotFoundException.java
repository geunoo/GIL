package com.example.hexagonalfeed.domain.feed.exception;

import com.example.hexagonalfeed.common.error.ErrorCode;
import com.example.hexagonalfeed.common.error.exception.CustomException;

public class FeedNotFoundException extends CustomException {

    public static final CustomException EXCEPTION = new FeedNotFoundException();

    private FeedNotFoundException() {
        super(ErrorCode.FEED_NOT_FOUND);

    }
}
