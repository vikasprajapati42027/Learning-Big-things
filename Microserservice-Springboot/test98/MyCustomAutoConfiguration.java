package com.example.starter;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyCustomAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public String customService() {
        return "Default logic: This runs only if the user didn't provide their own bean.";
    }
}
// This is the heart of every 'spring-boot-starter' library!
