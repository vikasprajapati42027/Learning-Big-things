package com.example.kafkalearning.test2.model;

import java.util.Map;

public class UserAction {
    private String userId;
    private String action;
    private Map<String, String> metadata;

    public UserAction() {
        // Jackson
    }

    public UserAction(String userId, String action, Map<String, String> metadata) {
        this.userId = userId;
        this.action = action;
        this.metadata = metadata;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Map<String, String> getMetadata() {
        return metadata;
    }

    public void setMetadata(Map<String, String> metadata) {
        this.metadata = metadata;
    }

    @Override
    public String toString() {
        return "UserAction{" +
                "userId='" + userId + '\'' +
                ", action='" + action + '\'' +
                ", metadata=" + metadata +
                '}';
    }
}
