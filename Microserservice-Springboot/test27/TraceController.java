package com.example.tracing;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TraceController {

    private static final Logger logger = LoggerFactory.getLogger(TraceController.class);
    private final TraceService traceService;

    public TraceController(TraceService traceService) {
        this.traceService = traceService;
    }

    @GetMapping("/trace")
    public String trace() {
        logger.info("Received request at /trace endpoint");
        return traceService.processData();
    }
}
