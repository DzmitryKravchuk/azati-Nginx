package org.example.consumer.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.consumer.persistence.entity.SimpleEntity;
import org.example.consumer.persistence.repositoty.SimpleRepository;
import org.example.consumer.service.SimpleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class SimpleServiceImpl implements SimpleService {
    private final SimpleRepository repository;

    @Override
    public SimpleEntity save(SimpleEntity simpleEntity) {
        log.info("SimpleServiceImpl save {}", simpleEntity);
        return repository.save(simpleEntity);
    }

}
