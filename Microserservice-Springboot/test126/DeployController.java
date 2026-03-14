package com.example.bluegreen;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeployController {

    @GetMapping("/version")
    public String getVersion() {
        // Switch this between BLUE and GREEN
        return "Current Deployment: GREEN (Production)";
    }
}
