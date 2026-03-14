package com.example.webmvc;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.stereotype.Service;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@Service
class GreetingService {
    public String greet(String name) { return "Hello, " + name; }
}

@RestController
class GreetingController {
    private final GreetingService service;
    GreetingController(GreetingService s) { this.service = s; }

    @GetMapping("/greet")
    public String greet() { return service.greet("Vikas"); }
}

@WebMvcTest(GreetingController.class)
public class MockMvcTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    GreetingService greetingService;

    @Test
    void testGreet() throws Exception {
        when(greetingService.greet("Vikas")).thenReturn("Hello, Vikas");
        mockMvc.perform(get("/greet"))
            .andExpect(status().isOk())
            .andExpect(content().string("Hello, Vikas"));
    }
}
