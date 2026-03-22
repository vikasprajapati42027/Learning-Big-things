# Hotel Booking Service (test10)

Spring Boot 3.2.x, Java 17 demo resembling Booking.com basics: room search, reservations, inventory with optimistic locking.

## Features
- List/search rooms by hotel name or room type
- Create rooms (seed data on startup)
- Create reservations with availability check and optimistic locking retry to handle concurrent bookings
- H2 in-memory DB

## Prerequisites
- Java 17, Maven 3.9+

## Run
```bash
cd java-backend-project/test10
mvn spring-boot:run
```
Service listens on `http://localhost:8600`.

## API
- `GET /rooms?hotelName=City&roomType=DELUXE` — search rooms
- `POST /rooms` — add room
  ```json
  {"hotelName":"Hill Top","roomType":"STANDARD","pricePerNight":80,"totalRooms":3}
  ```
- `POST /reservations` — create booking (decrements availability)
  ```json
  {"roomId":1,"guestName":"Alice","startDate":"2026-03-20","endDate":"2026-03-22"}
  ```
- `GET /reservations` — list reservations

## Concurrency strategy
- `HotelRoom` uses `@Version` for optimistic locking.
- `BookingService.reserve` retries on `OptimisticLockingFailureException` to handle concurrent decrements safely.

## Notes / next steps
- Add date overlap checks per room (currently only inventory count).
- Plug real database and authentication for multi-tenant usage.
- Consider distributed locks or Redis-based counters for cross-instance scaling.
