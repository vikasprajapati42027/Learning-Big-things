package com.example.annotations.controller;

import com.example.annotations.model.AnnotationDetail;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;

@RestController
public class AnnotationMasterController {

    @GetMapping("/annotations")
    public List<AnnotationDetail> getAllAnnotations() {
        List<AnnotationDetail> list = new ArrayList<>();
        
        // Core Spring
        list.add(new AnnotationDetail("@Component", "Core", "Marks a class as a Spring Bean", "@Component\npublic class MyBean {}"));
        list.add(new AnnotationDetail("@Autowired", "DI", "Injects a dependency automatically", "@Autowired\nprivate MyService service;"));
        list.add(new AnnotationDetail("@Value", "Config", "Injects values from properties", "@Value(\"${app.name}\")\nprivate String name;"));
        
        // Web
        list.add(new AnnotationDetail("@RestController", "Web", "Combines @Controller and @ResponseBody", "@RestController\npublic class Api {}"));
        list.add(new AnnotationDetail("@GetMapping", "Web", "Handles HTTP GET requests", "@GetMapping(\"/url\")"));
        
        // Security
        list.add(new AnnotationDetail("@PreAuthorize", "Security", "Checks permissions before execution", "@PreAuthorize(\"hasRole('ADMIN')\")"));
        
        // Add 100 entries here in a real large-scale project...
        // For this example, we provide the structure for all 100.
        
        return list;
    }
}
