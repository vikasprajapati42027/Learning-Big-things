package Test5;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @ConfigurationProperties maps a group of related properties to a Java object.
 * The 'prefix' tells Spring to look for properties starting with 'mail'.
 */
@Component
@ConfigurationProperties(prefix = "mail")
public class MailConfig {

    private String hostname;
    private int port;
    private String from;

    // Getters and Setters are MANDATORY for @ConfigurationProperties to work
    public String getHostname() { return hostname; }
    public void setHostname(String hostname) { this.hostname = hostname; }

    public int getPort() { return port; }
    public void setPort(int port) { this.port = port; }

    public String getFrom() { return from; }
    public void setFrom(String from) { this.from = from; }

    public void printMailConfig() {
        System.out.println("Grouped Property Injection via @ConfigurationProperties:");
        System.out.println("Mail Host: " + hostname);
        System.out.println("Mail Port: " + port);
        System.out.println("Mail From: " + from);
    }
}
