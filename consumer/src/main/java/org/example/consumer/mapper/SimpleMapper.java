package org.example.consumer.mapper;

import org.example.consumer.dto.SimpleCreateRequest;
import org.example.consumer.persistence.entity.SimpleEntity;
import org.springframework.stereotype.Component;

@Component
public class SimpleMapper {

    public SimpleEntity mapToEntity(SimpleCreateRequest request) {
        SimpleEntity entity = new SimpleEntity();
        entity.setIntValue(request.getIntValue());

        return entity;
    }

}
