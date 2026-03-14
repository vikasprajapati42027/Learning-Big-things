package com.example.sidecar;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainServiceController {

    @GetMapping("/business-logic")
    public String doWork() {
        return "Main Service processing business logic... (Logged by Sidecar)";
    }
}
