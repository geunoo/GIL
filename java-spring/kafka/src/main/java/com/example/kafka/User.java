package com.example.kafka;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class User {

    private String name;
    private Integer age;
    private Integer height;
    private Integer weight;
}
