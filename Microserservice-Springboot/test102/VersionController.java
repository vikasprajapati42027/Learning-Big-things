package com.example.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersionController {

    // URI Versioning
    @GetMapping("/v1/user")
    public String getUserV1() {
        return "User data format (V1)";
    }

    @GetMapping("/v2/user")
    public String getUserV2() {
        return "User data format (V2) - Includes new fields";
    }

    // Header Versioning
    @GetMapping(value = "/user", headers = "X-API-VERSION=1")
    public String getUserHeaderV1() {
        return "User data (V1) - Requested via Header";
    }
}
