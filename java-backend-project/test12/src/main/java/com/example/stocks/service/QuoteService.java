package com.example.stocks.service;

import com.example.stocks.model.StockQuote;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.OffsetDateTime;
import java.util.*;

@Service
public class QuoteService {
    private final Map<String, StockQuote> quotes = new HashMap<>();
    private final SimpMessagingTemplate messagingTemplate;
    private final Random random = new Random();

    public QuoteService(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
        seed();
    }

    public Collection<StockQuote> current() {
        return quotes.values();
    }

    @Scheduled(fixedRate = 1000)
    public void tick() {
        quotes.values().forEach(q -> {
            BigDecimal delta = BigDecimal.valueOf((random.nextDouble() - 0.5) * 0.5).setScale(2, RoundingMode.HALF_UP);
            BigDecimal newPrice = q.getPrice().add(delta).max(BigDecimal.valueOf(1.0));
            q.setChange(delta);
            q.setPrice(newPrice);
            q.setTimestamp(OffsetDateTime.now());
            messagingTemplate.convertAndSend("/topic/stocks", q);
        });
    }

    private void seed() {
        add("NSE:TCS", 3500.00);
        add("NSE:INFY", 1400.00);
        add("NSE:RELIANCE", 2800.00);
        add("NSE:HDFCBANK", 1600.00);
    }

    private void add(String symbol, double price) {
        quotes.put(symbol, new StockQuote(symbol, BigDecimal.valueOf(price), BigDecimal.ZERO, OffsetDateTime.now()));
    }
}
