package com.example.kafkalearning.test2.model;

import java.time.Instant;

public class UserActionCount {
    private String action;
    private Instant windowStart;
    private Instant windowEnd;
    private long count;

    public UserActionCount() {
        // Jackson
    }

    public UserActionCount(String action, Instant windowStart, Instant windowEnd, long count) {
        this.action = action;
        this.windowStart = windowStart;
        this.windowEnd = windowEnd;
        this.count = count;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Instant getWindowStart() {
        return windowStart;
    }

    public void setWindowStart(Instant windowStart) {
        this.windowStart = windowStart;
    }

    public Instant getWindowEnd() {
        return windowEnd;
    }

    public void setWindowEnd(Instant windowEnd) {
        this.windowEnd = windowEnd;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "UserActionCount{" +
                "action='" + action + '\'' +
                ", windowStart=" + windowStart +
                ", windowEnd=" + windowEnd +
                ", count=" + count +
                '}';
    }
}
