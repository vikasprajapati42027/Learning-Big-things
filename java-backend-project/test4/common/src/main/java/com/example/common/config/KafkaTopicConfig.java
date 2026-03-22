package com.example.common.config;

import com.example.common.constants.Topics;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass(NewTopic.class)
public class KafkaTopicConfig {
    @Bean
    public NewTopic rideRequested() { return new NewTopic(Topics.RIDE_REQUESTED, 1, (short) 1); }
    @Bean
    public NewTopic rideAssigned() { return new NewTopic(Topics.RIDE_ASSIGNED, 1, (short) 1); }
    @Bean
    public NewTopic rideStatus() { return new NewTopic(Topics.RIDE_STATUS, 1, (short) 1); }
}
