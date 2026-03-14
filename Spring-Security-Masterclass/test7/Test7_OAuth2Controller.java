package com.example.security;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.*;

@RestController
public class Test7_OAuth2Controller {

    @GetMapping("/profile")
    public String getProfile(@AuthenticationPrincipal OAuth2User principal) {
        // OAuth2User contains all data returned by Google/GitHub
        String name  = principal.getAttribute("name");
        String email = principal.getAttribute("email");
        return "Welcome " + name + " (" + email + ")";
    }
}
// Note: Properties in application.properties are required for this to work.
// spring.security.oauth2.client.registration.google.client-id=YOUR_ID
// spring.security.oauth2.client.registration.google.client-secret=YOUR_SECRET
