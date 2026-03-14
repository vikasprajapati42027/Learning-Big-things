# Test 7: Design a Notification System

## Requirements
- Send Email, SMS, and Push Notifications
- 10 million users, high throughput
- Different notification types: Marketing, Transactional, Reminders

## Architecture
```
API Request → Notification Service → Kafka Topic
                                        ↓
                              ┌────────────────┐
                              │  Email Worker  │ → SendGrid/SES
                              │  SMS Worker    │ → Twilio
                              │  Push Worker   │ → FCM/APNs
                              └────────────────┘
```

## User Preferences Table
```sql
CREATE TABLE notification_prefs (
    user_id BIGINT,
    channel  ENUM('email','sms','push'),
    type     ENUM('marketing','transactional','reminder'),
    enabled  BOOLEAN
);
```

## Priority Queues
- **Transactional** (OTP, password reset) → High-priority queue, processed first
- **Marketing** (sales) → Low-priority queue, processed in bulk

## Rate Limiting Notifications
- Max 5 SMS per user per day (prevents spam, reduces Twilio cost)
- Use Redis: `INCR notif:sms:{user_id}:{date}` + `EXPIRE` at midnight

## Retry Logic
- Email fails → Retry 3 times with exponential backoff (1s, 2s, 4s)
- After 3 failures → Dead Letter Queue for manual review
