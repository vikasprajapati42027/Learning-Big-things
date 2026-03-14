package com.example.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "app.email")
public class EmailProperties {
    private String host;
    private int port;
    private String username;
    private boolean debug;

    // Getters & Setters
    public String getHost() { return host; }
    public void setHost(String host) { this.host = host; }
    public int getPort() { return port; }
    public void setPort(int port) { this.port = port; }
    public String getUsername() { return username; }
    public void setUsername(String u) { this.username = u; }
    public boolean isDebug() { return debug; }
    public void setDebug(boolean d) { this.debug = d; }
}
