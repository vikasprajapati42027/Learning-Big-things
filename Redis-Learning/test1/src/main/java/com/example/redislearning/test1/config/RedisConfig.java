package com.example.redislearning.test1.config;

import com.example.redislearning.test1.model.ProfileCache;
import com.example.redislearning.test1.service.ProfileSubscriber;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;

@Configuration
public class RedisConfig {
    @Bean
    public LettuceConnectionFactory redisConnectionFactory() {
        RedisStandaloneConfiguration config = new RedisStandaloneConfiguration();
        config.setHostName("localhost");
        config.setPort(6379);
        return new LettuceConnectionFactory(config);
    }

    @Bean
    public RedisTemplate<String, ProfileCache> redisTemplate(LettuceConnectionFactory factory) {
        RedisTemplate<String, ProfileCache> template = new RedisTemplate<>();
        template.setConnectionFactory(factory);
        template.afterPropertiesSet();
        return template;
    }

    @Bean
    public ChannelTopic profileTopic() {
        return new ChannelTopic("profile-notifications");
    }

    @Bean
    public RedisMessageListenerContainer listenerContainer(LettuceConnectionFactory factory,
                                                             MessageListenerAdapter listenerAdapter,
                                                             ChannelTopic topic) {
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(factory);
        container.addMessageListener(listenerAdapter, topic);
        return container;
    }

    @Bean
    public MessageListenerAdapter listenerAdapter(ProfileSubscriber subscriber) {
        return new MessageListenerAdapter(subscriber, "handleNotification");
    }
}
