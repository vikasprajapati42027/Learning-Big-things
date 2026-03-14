package com.example.chaos;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChaosController {

    @GetMapping("/critical-feature")
    public String checkFeature() {
        // Chaos Monkey might inject latency or exceptions here
        return "Critical Feature is responding normally.";
    }
}
