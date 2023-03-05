package com.example.feed

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class FeedApplication

fun main(args: Array<String>) {
    runApplication<FeedApplication>(*args)
}
