# Test 64: Webhooks

Receiving real-time push notifications from external services like Stripe or GitHub.

## Key Files:
- `WebhookController.java`: An endpoint that listens for events posted by external platforms.
- `EXPLANATION.md`: Webhooks vs Polling.

## Concept:
Instead of asking Stripe "Did the payment succeed?" every 5 seconds (Polling), Stripe calls YOUR endpoint the moment the payment succeeds (Webhook). It's much more efficient and instantaneous.
