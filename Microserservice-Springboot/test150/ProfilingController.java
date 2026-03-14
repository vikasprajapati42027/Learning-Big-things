package com.example.performance;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProfilingController {

    @GetMapping("/analyze")
    public String heavyLogic() {
        // This is where Java Mission Control (JMC) and Flight Recorder (JFR)
        // look for CPU spikes and memory leaks.
        long sum = 0;
        for (int i = 0; i < 1_000_000; i++) {
            sum += i;
        }
        return "Calculation finished. Analyze the JFR recording to see the CPU impact!";
    }
}
