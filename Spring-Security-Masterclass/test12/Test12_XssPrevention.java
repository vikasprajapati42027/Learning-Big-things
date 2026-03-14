package com.example.security;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

@RestController
@RequestMapping("/api/xss")
public class Test12_XssPrevention {

    // ❌ VULNERABLE: Returns raw user input
    @GetMapping("/echo-unsafe")
    public String echoUnsafe(@RequestParam String name) {
        return "Hello " + name; // If name is <script>alert(1)</script>, it runs!
    }

    // ✅ SAFE: Escapes user input
    @GetMapping("/echo-safe")
    public String echoSafe(@RequestParam String name) {
        // Turns < to &lt;, > to &gt; etc.
        String safeName = HtmlUtils.htmlEscape(name);
        return "Hello " + safeName;
    }
}
// Note: In modern frontend frameworks like React/Angular, 
// XSS protection is mostly built-in!
