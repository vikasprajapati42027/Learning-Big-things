package com.example.presence.model;

import jakarta.persistence.*;

@Entity
@Table(name = "presence")
public class Presence {
    @Id
    private String username;
    private String status;
    private long updatedAt;

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public long getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(long updatedAt) { this.updatedAt = updatedAt; }
}
