package com.example.cache;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class ReactiveCacheService {

    private final ConcurrentHashMap<String, String> cache = new ConcurrentHashMap<>();

    public Mono<String> getData(String key) {
        // Return from cache if present, else compute and save
        return Mono.justOrEmpty(cache.get(key))
                   .switchIfEmpty(Mono.fromCallable(() -> "Computed Value")
                                      .doOnNext(val -> cache.put(key, val)));
    }
}
