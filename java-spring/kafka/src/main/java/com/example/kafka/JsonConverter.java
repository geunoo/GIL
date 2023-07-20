package com.example.kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class JsonConverter<T> {

    private final ObjectMapper objectMapper;

    public T convert(String jsonString, Class<T> valueType) {
        try {
            return objectMapper.readValue(jsonString, valueType);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
