package com.example.hexagonalfeed;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class HexagonalFeedApplication {

    public static void main(String[] args) {
        SpringApplication.run(HexagonalFeedApplication.class, args);
    }

}
