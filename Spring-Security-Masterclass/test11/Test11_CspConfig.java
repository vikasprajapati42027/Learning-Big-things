package com.example.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.header.writers.contentsecuritypolicy.ContentSecurityPolicyHeaderWriter;

@Configuration
public class Test11_CspConfig {

    @Bean
    public SecurityFilterChain cspFilterChain(HttpSecurity http) throws Exception {
        http
            .headers(headers -> headers
                .contentSecurityPolicy(csp -> csp
                    .policyDirectives("default-src 'self'; script-src 'self' https://trusted.cdn.com; object-src 'none';")
                )
            );
        return http.build();
    }
}
