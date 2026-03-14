# Test 1: Load Balancing

## Simple Explanation
When millions of users hit your site, one server can't handle it all.
A Load Balancer is a "Traffic Cop" that distributes requests across many servers.

## 3 Main Algorithms
| Algorithm | Logic | Best For |
|-----------|-------|---------|
| **Round Robin** | Server1, Server2, Server3, Server1... | Equal servers |
| **Least Connections** | Send to server with fewest active requests | Unequal task lengths |
| **IP Hash** | Same user → always same server | Session-based apps |

## Diagram
```
Users →  [Load Balancer]  →  Server 1
                          →  Server 2
                          →  Server 3
```

## Sticky Sessions
When a user must ALWAYS go to the same server (because session lives there).
Problem: Server failure = session lost.
Better Fix: Use Redis to store sessions centrally — any server can serve any user!
