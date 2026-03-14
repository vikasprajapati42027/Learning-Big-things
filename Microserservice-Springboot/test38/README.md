# Test 38: Backends for Frontends (BFF)

Different APIs for different devices.

## The Problem:
A **Mobile App** needs very little data (small screen, slow internet).
A **Desktop Website** needs "Heavy" data (big screen, fast fiber).

Should you use the same API for both? 
- If you use the Mobile API for desktop, the website is slow (needs 10 calls).
- If you use the Desktop API for mobile, it's slow (downloads 5MB of extra JSON).

## The Solution (BFF):
You create two small gateway services:
1. **Mobile-BFF**: Calls internal services and returns only 5 fields.
2. **Desktop-BFF**: Calls internal services and returns 50 fields.

Each "Frontend" gets exactly what it needs!
