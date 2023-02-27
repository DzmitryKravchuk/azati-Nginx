package org.example.producer.service.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.assertj.core.api.Assertions;
import org.example.producer.dto.SimpleCreateRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = {JsonMapper.class,
        ObjectMapper.class})
class JsonMapperTest {

    @Autowired
    private JsonMapper mapper;

    private static final String EXPECTED_REQUEST = "{\"intValue\":100}";

    @Test
    void shouldMapObjToString() throws JsonProcessingException {
        // given
        SimpleCreateRequest request = new SimpleCreateRequest(100);

        // when
        String msg = mapper.mapToString(request);

        // then
        Assertions.assertThat(msg).isEqualTo(EXPECTED_REQUEST);

    }

}