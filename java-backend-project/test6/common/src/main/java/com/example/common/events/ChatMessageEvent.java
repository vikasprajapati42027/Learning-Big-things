package com.example.common.events;

public record ChatMessageEvent(String roomId, String fromUser, String content, long timestamp) {
}
