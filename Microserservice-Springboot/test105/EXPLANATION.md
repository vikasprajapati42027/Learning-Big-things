# Test 105: Idempotency Key Pattern

Preventing duplicate actions (like double payments) from network retries.

## Key Files:
- `PaymentController.java`: Demonstrates using a unique key to identify and skip duplicate requests.
- `EXPLANATION.md`: Why APIs should always be Idempotent.

## Concept:
If a user clicks "Pay" and their internet blinks, their phone might send the request twice. Without an Idempotency Key, they get charged twice. With the key, the server says, "I already saw this key, I won't charge again!"
