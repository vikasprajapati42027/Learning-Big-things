package com.example.tracing;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PropagatorController {

    @GetMapping("/hop")
    public String checkTraceHeader(@RequestHeader(value = "X-B3-TraceId", required = false) String traceId) {
        // Sleuth automatically propagates X-B3-TraceId across services
        return "Incoming Trace ID (automatically attached): " + traceId;
    }
}
