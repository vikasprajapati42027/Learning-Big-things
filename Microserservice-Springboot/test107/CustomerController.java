package com.example.multitenant;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    @GetMapping("/data")
    public String getCustomerData(@RequestHeader("X-Tenant-ID") String tenantId) {
        // Data Isolation in SaaS
        return "Fetching private data for Client: " + tenantId + " from isolated storage.";
    }
}
