package com.example.urlshortener.dto;

import java.time.Instant;

public record UrlStatsResponse(String code, String originalUrl, long clickCount, Instant createdAt) { }
