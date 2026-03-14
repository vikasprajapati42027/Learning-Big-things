package com.example.security;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;
import java.io.IOException;

// Test 15: Custom Filter at a specific position
@Component
public class Test15_CustomHeaderFilter extends GenericFilter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
            throws IOException, ServletException {
        
        HttpServletRequest req = (HttpServletRequest) request;
        String apiKey = req.getHeader("X-API-KEY");

        if ("SECRET_GATEWAY_KEY".equals(apiKey)) {
            System.out.println("Valid API Key found!");
        } else {
            System.out.println("Warning: Request without valid Gateway Key");
        }

        chain.doFilter(request, response);
    }
}

// In your SecurityConfig:
// http.addFilterBefore(new Test15_CustomHeaderFilter(), UsernamePasswordAuthenticationFilter.class);
