package org.example.consumer.service.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JsonMapper {

    private final ObjectMapper objectMapper;

    String mapToString(Object request) throws JsonProcessingException {
        return objectMapper.writeValueAsString(request);
    }

    public <T> T mapToObject(String message, Class<T> clazz) throws IOException {
        return objectMapper.readValue(message, clazz);
    }

}
