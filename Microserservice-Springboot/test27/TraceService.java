package com.example.tracing;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class TraceService {

    private static final Logger logger = LoggerFactory.getLogger(TraceService.class);

    public String processData() {
        logger.info("Processing data in Service layer...");
        // Zipkin/Sleuth will automatically attach TraceId and SpanId to these logs
        return "Data processed successfully with tracing!";
    }
}
