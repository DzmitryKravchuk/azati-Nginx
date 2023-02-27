package org.example.consumer.service.kafka;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.consumer.dto.SimpleCreateRequest;
import org.example.consumer.mapper.SimpleMapper;
import org.example.consumer.service.SimpleService;
import org.example.consumer.service.utils.JsonMapper;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Slf4j
@Service
@RequiredArgsConstructor
public class Consumer {

    private final SimpleService service;
    private final JsonMapper jsonMapper;
    private final SimpleMapper simpleMapper;

    @KafkaListener(topics = "${spring.kafka.topic}",
            groupId = "${spring.kafka.consumer.group-id}")
    public void consume(String message) {
        log.info("consume(): {}", message);
        SimpleCreateRequest request = null;
        try {
            request = jsonMapper.mapToObject(message, SimpleCreateRequest.class);
        } catch (IOException e) {
            log.info("Failed to parse object from message: {}", message);
            e.printStackTrace();
        }
        if (request != null) {
            service.save(simpleMapper.mapToEntity(request));
        }
    }
}
