package com.example.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.*;

@Component
class LoggingInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler) {
        System.out.printf("[INTERCEPTOR] %s %s from IP: %s%n",
            req.getMethod(), req.getRequestURI(), req.getRemoteAddr());
        return true; // returning false would block the request
    }

    @Override
    public void afterCompletion(HttpServletRequest req, HttpServletResponse res, Object h, Exception e) {
        System.out.println("[INTERCEPTOR] Response status: " + res.getStatus());
    }
}

@Component
class InterceptorConfig implements WebMvcConfigurer {
    private final LoggingInterceptor interceptor;
    InterceptorConfig(LoggingInterceptor i) { this.interceptor = i; }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(interceptor).addPathPatterns("/api/**");
    }
}
