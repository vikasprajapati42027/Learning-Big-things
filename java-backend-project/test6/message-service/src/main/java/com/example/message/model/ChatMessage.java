package com.example.message.model;

import jakarta.persistence.*;

@Entity
@Table(name = "messages")
public class ChatMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String roomId;
    private String fromUser;
    @Column(length = 1000)
    private String content;
    private long timestamp;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getRoomId() { return roomId; }
    public void setRoomId(String roomId) { this.roomId = roomId; }
    public String getFromUser() { return fromUser; }
    public void setFromUser(String fromUser) { this.fromUser = fromUser; }
    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }
    public long getTimestamp() { return timestamp; }
    public void setTimestamp(long timestamp) { this.timestamp = timestamp; }
}
