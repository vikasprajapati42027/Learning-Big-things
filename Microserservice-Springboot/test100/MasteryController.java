package com.example.mastery;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
public class MasteryController {

    @GetMapping("/mastery-status")
    public Map<String, Object> getStatus() {
        return Map.of(
            "Level", 100,
            "ConceptsMastered", "100+",
            "Status", "Spring Boot Architect",
            "Message", "Congratulations on completing the journey, Vikas!"
        );
    }
}
