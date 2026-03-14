package com.example.canary;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersionController {

    @Value("${app.version:1.0.0}")
    private String version;

    @Value("${app.release.type:Stable}")
    private String releaseType;

    @GetMapping("/version")
    public String getVersion() {
        return "Service Version: " + version + " (" + releaseType + ")";
    }
}
