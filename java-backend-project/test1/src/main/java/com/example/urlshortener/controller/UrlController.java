package com.example.urlshortener.controller;

import com.example.urlshortener.dto.CreateShortUrlRequest;
import com.example.urlshortener.dto.CreateShortUrlResponse;
import com.example.urlshortener.dto.UrlStatsResponse;
import com.example.urlshortener.model.UrlMapping;
import com.example.urlshortener.service.UrlService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/urls")
public class UrlController {
    private final UrlService service;

    public UrlController(UrlService service) {
        this.service = service;
    }

    @PostMapping("/shorten")
    public CreateShortUrlResponse shorten(@RequestBody CreateShortUrlRequest request, @RequestHeader(value = "Host") String host) {
        String base = "http://" + host;
        return service.createShortUrl(request, base);
    }

    @GetMapping("/{code}")
    public ResponseEntity<Void> redirect(@PathVariable String code) {
        Optional<UrlMapping> found = service.resolve(code);
        if (found.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        service.incrementClicks(found.get());
        return ResponseEntity.status(302).location(URI.create(found.get().getOriginalUrl())).build();
    }

    @GetMapping("/{code}/stats")
    public ResponseEntity<UrlStatsResponse> stats(@PathVariable String code) {
        return service.stats(code)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
