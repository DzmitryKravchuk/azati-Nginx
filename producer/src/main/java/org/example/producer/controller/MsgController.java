package org.example.producer.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.example.producer.dto.SimpleCreateRequest;
import org.example.producer.service.Producer;
import org.example.producer.service.utils.JsonMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/message")
@RequiredArgsConstructor
public class MsgController {

    private final Producer producer;
    private final JsonMapper mapper;


    @PostMapping(value = "/publish")
    public void sendMessageToKafkaTopic(@RequestParam("intValue") Integer intValue) throws JsonProcessingException {
        SimpleCreateRequest request = new SimpleCreateRequest(intValue);
        String message = mapper.mapToString(request);
        this.producer.sendMessage(message);
    }
}
