package com.example.stocks.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public class StockQuote {
    private String symbol;
    private BigDecimal price;
    private BigDecimal change;
    private OffsetDateTime timestamp;

    public StockQuote() {}

    public StockQuote(String symbol, BigDecimal price, BigDecimal change, OffsetDateTime timestamp) {
        this.symbol = symbol;
        this.price = price;
        this.change = change;
        this.timestamp = timestamp;
    }

    public String getSymbol() { return symbol; }
    public void setSymbol(String symbol) { this.symbol = symbol; }
    public BigDecimal getPrice() { return price; }
    public void setPrice(BigDecimal price) { this.price = price; }
    public BigDecimal getChange() { return change; }
    public void setChange(BigDecimal change) { this.change = change; }
    public OffsetDateTime getTimestamp() { return timestamp; }
    public void setTimestamp(OffsetDateTime timestamp) { this.timestamp = timestamp; }
}
