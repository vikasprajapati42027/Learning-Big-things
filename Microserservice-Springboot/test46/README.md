# Test 46: Zero Trust Networking

Trust no one, even inside the walls.

## The Old Way (Perimeter Security):
We have a huge firewall. If you are "inside" the company network, you can access every microservice without a password.

## The New Way (Zero Trust):
Even if Service A is sitting right next to Service B on the same server, B still asks A for a **Certificate (mTLS)** and a **Token**.
Every single call between microservices is encrypted and verified.

## Why?
Because if a hacker breaks into just ONE small service, they can't travel to any other service. Every door is locked!
