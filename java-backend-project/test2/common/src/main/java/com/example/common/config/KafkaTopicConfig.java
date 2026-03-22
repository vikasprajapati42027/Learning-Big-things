package com.example.common.config;

import com.example.common.constants.Topics;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Declares Kafka topics on startup to simplify local development.
 */
@Configuration
@ConditionalOnClass(NewTopic.class)
public class KafkaTopicConfig {

    @Bean
    public NewTopic ordersCreatedTopic() {
        return new NewTopic(Topics.ORDERS_CREATED, 1, (short) 1);
    }

    @Bean
    public NewTopic paymentsCompletedTopic() {
        return new NewTopic(Topics.PAYMENTS_COMPLETED, 1, (short) 1);
    }
}
