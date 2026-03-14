# Test 9: Design a Payment Gateway

## Critical Requirements
- Payments MUST be idempotent (no double charges)
- PCI-DSS compliance (card data security)
- Sub-second response time
- 99.999% availability

## Idempotency (Most Important!)
```
Client sends payment request with unique Idempotency-Key: "order-507-attempt-1"
Server checks: Have I seen this key before?
  YES → Return previous result (no new charge)
  NO  → Process payment, store result with key
```

## Payment Flow
```
User → API Gateway → Payment Service → Fraud Check → Bank/Card Network
                           ↓
                    Idempotency Store (Redis)
                           ↓
                    Save to Database (ACID transaction)
                           ↓
                    Publish Event → Notification Service
```

## Handling Bank Timeouts
- Bank call times out after 30s
- Payment is in UNKNOWN state!
- Solution: Store as PENDING → Background job calls bank's status API every 30s
- Eventually: CONFIRMED or FAILED

## Security
- NEVER store full card numbers → Use tokenization (Stripe Token, Visa Token)
- All API calls must be HTTPS
- Encrypt card data at field level (AES-256)
- Audit log: who accessed payment data, when, from where
