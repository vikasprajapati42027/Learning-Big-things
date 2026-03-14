# Design Uber (High Level)

## 1. Requirements
- Riders can see nearby Drivers.
- Riders can request a ride.
- Drivers can accept/reject ride.
- Track Driver location in real-time.

## 2. Key Components
- **User Service**: Auth/Profile.
- **Driver Service**: Status/Availability.
- **Location Service (Geospatial)**:
  - Uses **QuadTree** or **Google S2 Library** to find points near a Lat/Lon.
  - Redis for fast location updates (Driver sends heartbeats every 5s).
- **Matchmaking Service**: Finds the best driver for the rider.
- **Trip Service**: Store trip status (Start, In Progress, Complete).

## 3. Database
- Real-time locations: Redis.
- Historical Trips: Cassandra (Scalable writes).
- Users/Payments: MySQL (ACID).
