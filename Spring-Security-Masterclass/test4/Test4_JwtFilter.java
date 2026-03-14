package com.example.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.http.*;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import java.io.IOException;
import java.util.List;

@Component
public class Test4_JwtFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain chain)
            throws jakarta.servlet.ServletException, IOException {

        String header = request.getHeader("Authorization");

        if (header == null || !header.startsWith("Bearer ")) {
            chain.doFilter(request, response);
            return; // No token? Let the request proceed (public endpoints allowed)
        }

        String token = header.substring(7); // Remove "Bearer " prefix

        // Normally: call JwtService.extractUsername(token)
        // For demo: assume token "valid-token" is always valid
        if ("valid-token".equals(token)) {
            var auth = new UsernamePasswordAuthenticationToken(
                "vikas", null, List.of() // username, credentials, authorities
            );
            SecurityContextHolder.getContext().setAuthentication(auth);
            System.out.println("JWT Filter: Token valid, user authenticated");
        }

        chain.doFilter(request, response);
    }
}
