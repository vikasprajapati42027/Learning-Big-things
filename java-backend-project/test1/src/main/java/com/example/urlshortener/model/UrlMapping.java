package com.example.urlshortener.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.Instant;

@Entity
@Table(name = "url_mapping", indexes = {
        @Index(name = "idx_short_code", columnList = "shortCode", unique = true)
})
@Data
@EqualsAndHashCode(of = "id")
@ToString
public class UrlMapping {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 2048)
    private String originalUrl;

    @Column(nullable = false, unique = true, length = 16)
    private String shortCode;

    @Column(nullable = false)
    private Long clickCount = 0L;

    @Column(nullable = false, updatable = false)
    private Instant createdAt = Instant.now();
}
