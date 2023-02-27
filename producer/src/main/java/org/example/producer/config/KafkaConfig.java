package org.example.producer.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaConfig {
    @Value("${spring.kafka.topic}")
    private String topic;

    @Bean
    public KafkaProperties kafkaProperties(){
        KafkaProperties props = new KafkaProperties();
        props.setTopic(topic);

        return props;
    }

}
