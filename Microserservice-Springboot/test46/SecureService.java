package com.example.zerotrust;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecureService {

    @GetMapping("/internal/data")
    public String getInternalData(@RequestHeader("X-Service-Auth") String auth) {
        if ("SECURE_TOKEN".equals(auth)) {
            return "Highly sensitive internal data (Verified)";
        }
        return "Access Denied: Untrusted request!";
    }
}
