# Test 32: Consistent Hashing

## Simple Explanation
In a distributed system with 100 cache servers, how do you decide which server stores `key="user:1"`?

## The Old Way: `hash(key) % 100`
This works until you add server #101. Now `hash(key) % 101` gives a different answer for EVERY key! Your entire cache suddenly becomes "Empty" and your database crashes.

## The New Way: Consistent Hashing
Instead of a simple modulo, imagine a **Ring** (0 to 2^32). 
1. Map every **SERVER** to a point on the ring.
2. Map every **KEY** to a point on the ring.
3. The Key is stored on the **next server** in the clockwise direction.

## Benefit
If you add or remove a server, you only need to move **1/N** of the keys! (e.g., Only 1% of keys move if you have 100 servers). 

## Who uses it?
- **Discord** (to route you to the right chat server).
- **Amazon DynamoDB**.
- **Cassandra**.
- **Load Balancers**.
