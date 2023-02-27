package org.example.consumer.service.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.assertj.core.api.Assertions;
import org.example.consumer.dto.SimpleCreateRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;


@SpringBootTest(classes = {JsonMapper.class,
        ObjectMapper.class})
class JsonMapperTest {

    @Autowired
    private JsonMapper mapper;

    private static final String REQUEST = "{\"intValue\":100}";

    private static final Integer EXPECTED_INT = 100;

    @Test
    void shouldMapStringToObject() throws IOException {
        // given
        // when
        SimpleCreateRequest actual = mapper.mapToObject(REQUEST,SimpleCreateRequest.class);

        // then
        Assertions.assertThat(actual.getIntValue()).isEqualTo(EXPECTED_INT);

    }

}