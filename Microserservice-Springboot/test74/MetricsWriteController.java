package com.example.timeseries;

import org.influxdb.annotation.Measurement;
import org.influxdb.annotation.TimeColumn;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.time.Instant;

@RestController
public class MetricsWriteController {

    @PostMapping("/record-metric")
    public String record(@RequestParam String name, @RequestParam double value) {
        // InfluxDB stores data with timestamps automatically
        System.out.printf("Writing metric [%s = %.2f] at %s%n", name, value, Instant.now());
        return "Metric recorded in Time-Series DB";
    }
}
