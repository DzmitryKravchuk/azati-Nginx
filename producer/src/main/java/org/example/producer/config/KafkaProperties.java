package org.example.producer.config;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class KafkaProperties {
    private String topic;
    private String groupId;
}
