package com.example.urlshortener.service;

import com.example.urlshortener.dto.CreateShortUrlRequest;
import com.example.urlshortener.dto.CreateShortUrlResponse;
import com.example.urlshortener.dto.UrlStatsResponse;
import com.example.urlshortener.model.UrlMapping;
import com.example.urlshortener.repository.UrlMappingRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.SecureRandom;
import java.util.Base64;
import java.util.Optional;

@Service
public class UrlService {
    private final UrlMappingRepository repository;
    private final SecureRandom random = new SecureRandom();
    private static final char[] ALPHABET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();

    public UrlService(UrlMappingRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public CreateShortUrlResponse createShortUrl(CreateShortUrlRequest request, String host) {
        String code = generateCode(7);
        UrlMapping mapping = new UrlMapping();
        mapping.setOriginalUrl(request.url());
        mapping.setShortCode(code);
        repository.save(mapping);
        return new CreateShortUrlResponse(host + "/" + code, code);
    }

    @Cacheable(cacheNames = "codeToUrl", key = "#code")
    public Optional<UrlMapping> resolve(String code) {
        return repository.findByShortCode(code);
    }

    @Transactional
    public void incrementClicks(UrlMapping mapping) {
        mapping.setClickCount(mapping.getClickCount() + 1);
        repository.save(mapping);
    }

    public Optional<UrlStatsResponse> stats(String code) {
        return repository.findByShortCode(code)
                .map(m -> new UrlStatsResponse(code, m.getOriginalUrl(), m.getClickCount(), m.getCreatedAt()));
    }

    private String generateCode(int length) {
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(ALPHABET[random.nextInt(ALPHABET.length)]);
        }
        return sb.toString();
    }
}
