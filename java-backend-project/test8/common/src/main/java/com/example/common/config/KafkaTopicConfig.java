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
    public NewTopic notificationsTopic() {
        return new NewTopic(Topics.NOTIFICATIONS, 1, (short) 1);
    }
}
