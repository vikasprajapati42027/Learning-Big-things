package com.example.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;
import java.io.IOException;

@Component
public class RequestIdFilter implements Filter {

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpReq = (HttpServletRequest) req;
        String requestId = httpReq.getHeader("X-Request-ID");
        if (requestId == null) requestId = java.util.UUID.randomUUID().toString();

        // Attach to MDC for logging (so every log line has the request ID)
        org.slf4j.MDC.put("requestId", requestId);
        System.out.println("[FILTER] Request #" + requestId + " → " + httpReq.getRequestURI());

        chain.doFilter(req, res);

        org.slf4j.MDC.clear();
    }
}
