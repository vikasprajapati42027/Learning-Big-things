package com.example.mesh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ServiceMeshApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceMeshApplication.class, args);
    }

    @GetMapping("/service-info")
    public String serviceInfo() {
        return "Service Mesh manages: mTLS encryption, retries, circuit breaking at the infrastructure layer. "
             + "Your code stays clean!";
    }
}
