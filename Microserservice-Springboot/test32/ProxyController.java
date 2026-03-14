package com.example.gateway;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProxyController {

    @GetMapping("/api/resource")
    public String getResource() {
        return "Protected Resource Accessed! (Rate Limiting check passed)";
    }
}
