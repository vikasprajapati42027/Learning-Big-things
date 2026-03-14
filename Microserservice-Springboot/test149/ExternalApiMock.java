package com.example.mock;

import org.springframework.stereotype.Service;

@Service
public class ExternalApiMock {

    public String getMockResponse() {
        // WireMock allows us to simulate a 3rd party API that is slow or failing
        return "{ \"status\": \"Success\", \"data\": \"This is a simulated JSON response\" }";
    }
}
