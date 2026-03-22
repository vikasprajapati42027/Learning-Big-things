# Real-Time Stock Feed (test12)

Spring Boot 3.2.x demo that streams simulated NSE-style quotes over WebSocket.

## Features
- WebSocket/STOMP endpoint `/ws` with broadcast topic `/topic/stocks`
- Auto-refreshing quotes every second with random walk pricing
- REST `GET /stocks` to fetch latest snapshot

## Prerequisites
- Java 17, Maven 3.9+

## Run
```bash
cd java-backend-project/test12
mvn spring-boot:run
```
Service runs on `http://localhost:8800`.

## WebSocket usage
- Connect to `ws://localhost:8800/ws` (SockJS enabled)
- Subscribe to `/topic/stocks`
- Every second you receive JSON `StockQuote` objects: `{symbol, price, change, timestamp}`

## REST
- `GET /stocks` → array of current quotes

## Notes
- Prices are simulated (random walk) and seeded with a few NSE tickers.
- Swap `QuoteService` to plug real market data or Kafka feed; the WebSocket layer stays the same.
