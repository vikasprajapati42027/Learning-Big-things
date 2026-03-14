# Test 19: Proxy vs Reverse Proxy

## Forward Proxy (The Client's Friend)
The proxy sits in front of the **CLIENTS**. 
- **Goal**: Hide the client's IP, filter outgoing traffic (company firewalls).
- **Example**: A company proxy that blocks social media.

## Reverse Proxy (The Server's Friend)
The proxy sits in front of the **SERVERS**.
- **Goal**: Load balancing, SSL termination, caching, hiding backend IPs.
- **Example**: NGINX, HAProxy, AWS ALB.

## Summary
- **Proxy**: Clients talk to it to reach the Internet.
- **Reverse Proxy**: The Internet talks to it to reach your Apps.
