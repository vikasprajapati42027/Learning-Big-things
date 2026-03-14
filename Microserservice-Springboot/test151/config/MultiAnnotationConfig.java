package com.example.annotations.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Showcase of Configuration-related annotations.
 */
@Configuration
@EnableAsync
@EnableScheduling
@Profile("dev")
@ConfigurationProperties(prefix = "app")
public class MultiAnnotationConfig {

    @Bean
    @ConditionalOnProperty(name = "feature.enabled", havingValue = "true")
    public String conditionalBean() {
        return "Active only if feature.enabled=true";
    }
}
