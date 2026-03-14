package com.example.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "user-service", fallback = UserFallback.class)
public interface UserClient {
    @GetMapping("/users/profile")
    String getUserProfile();
}

@Component
class UserFallback implements UserClient {
    @Override
    public String getUserProfile() {
        return "Cache Version of Profile (Service is down)";
    }
}
