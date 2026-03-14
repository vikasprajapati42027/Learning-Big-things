import java.util.concurrent.atomic.AtomicLong;

// System Design: Rate Limiting Algorithm (Token Bucket)
public class TokenBucket {
    private final long capacity;
    private final long refillRate; // tokens per second
    private AtomicLong currentTokens;
    private long lastRefillTimestamp;

    public TokenBucket(long capacity, long refillRate) {
        this.capacity = capacity;
        this.refillRate = refillRate;
        this.currentTokens = new AtomicLong(capacity);
        this.lastRefillTimestamp = System.currentTimeMillis();
    }

    public synchronized boolean allowRequest() {
        refill();
        if (currentTokens.get() > 0) {
            currentTokens.decrementAndGet();
            return true;
        }
        return false;
    }

    private void refill() {
        long now = System.currentTimeMillis();
        long tokensToAdd = (now - lastRefillTimestamp) * refillRate / 1000;
        if (tokensToAdd > 0) {
            currentTokens.set(Math.min(capacity, currentTokens.get() + tokensToAdd));
            lastRefillTimestamp = now;
        }
    }
}
