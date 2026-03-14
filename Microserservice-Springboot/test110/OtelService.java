package com.example.tracing;

import io.opentelemetry.instrumentation.annotations.WithSpan;
import org.springframework.stereotype.Service;

@Service
public class OtelService {

    @WithSpan("process-business-data")
    public void processData() {
        // This method automatically creates a specialized "Span" in Jaeger/Zipkin
        System.out.println("Processing data with OpenTelemetry instrumentation...");
    }
}
