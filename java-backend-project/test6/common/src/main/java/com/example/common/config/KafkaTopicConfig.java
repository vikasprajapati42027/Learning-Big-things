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
    public NewTopic chatMessages() { return new NewTopic(Topics.CHAT_MESSAGES, 1, (short) 1); }
    @Bean
    public NewTopic presenceEvents() { return new NewTopic(Topics.PRESENCE_EVENTS, 1, (short) 1); }
}
