package com.example.security;

import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.*;
import org.springframework.stereotype.Component;

// Test 10: Security Events — Auditing Login Activity
@Component
public class Test10_SecurityAuditListener {

    // Successful login
    @org.springframework.context.event.EventListener
    public void onAuthSuccess(AuthenticationSuccessEvent event) {
        String username = event.getAuthentication().getName();
        System.out.println("[AUDIT] SUCCESS: User '" + username + "' logged in at " + java.time.LocalDateTime.now());
        // In production: save to AuditLog table in DB
    }

    // Failed login
    @org.springframework.context.event.EventListener
    public void onAuthFailure(AbstractAuthenticationFailureEvent event) {
        String username = event.getAuthentication().getName();
        String reason   = event.getException().getMessage();
        System.out.println("[AUDIT] FAILURE: Login attempt for '" + username + "' → " + reason);
        // In production: alert if > 5 failures from same user
    }
}
