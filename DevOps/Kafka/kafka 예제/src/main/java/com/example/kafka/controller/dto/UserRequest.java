package com.example.kafka.controller.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserRequest {

    private String name;
    private Integer age;
    private Integer height;
    private Integer weight;
}
