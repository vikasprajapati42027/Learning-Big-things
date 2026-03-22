package com.example.stocks.controller;

import com.example.stocks.model.StockQuote;
import com.example.stocks.service.QuoteService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/stocks")
public class StockController {
    private final QuoteService quoteService;

    public StockController(QuoteService quoteService) {
        this.quoteService = quoteService;
    }

    @GetMapping
    public Collection<StockQuote> list() {
        return quoteService.current();
    }
}
