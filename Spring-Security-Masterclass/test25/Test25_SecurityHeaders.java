package com.example.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

// Test 25: Common Security Headers
@Configuration
public class Test25_SecurityHeaders {

    @Bean
    public SecurityFilterChain headerFilterChain(HttpSecurity http) throws Exception {
        http
            .headers(headers -> headers
                // 1. HSTS: Forces browser to use HTTPS only
                .httpStrictTransportSecurity(hsts -> hsts
                    .includeSubDomains(true)
                    .maxAgeInSeconds(31536000)
                )
                // 2. X-Frame-Options: Prevents Clickjacking
                .frameOptions(frame -> frame.deny())
                // 3. X-Content-Type-Options: Prevents MIME sniffing
                .contentTypeOptions(conf -> conf.disable()) // Spring enables this by default!
            );
        return http.build();
    }
}
