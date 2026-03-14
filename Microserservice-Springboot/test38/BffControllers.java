package com.example.bff;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
@RequestMapping("/mobile")
public class MobileBffController {

    @GetMapping("/user-summary")
    public Map<String, String> getSummary() {
        // Returns minimal data for mobile screens
        return Map.of("name", "Vikas", "status", "Active");
    }
}

@RestController
@RequestMapping("/desktop")
class DesktopBffController {

    @GetMapping("/user-details")
    public Map<String, Object> getDetails() {
        // Returns full data for desktop screens
        return Map.of(
            "name", "Vikas",
            "status", "Active",
            "address", "123 Street, City",
            "lastLogin", "2026-03-14",
            "preferences", Map.of("theme", "dark", "notifications", true)
        );
    }
}
