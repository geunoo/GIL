package com.example.kafka;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@ToString
public class User {

    private String name;
    private Integer age;
    private Integer height;
    private Integer weight;

    @Builder
    public User(String name, Integer age, Integer height, Integer weight) {
        this.name = name;
        this.age = age;
        this.height = height;
        this.weight = weight;
    }
}
