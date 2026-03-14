package Test50;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.socket.config.annotation.EnableWebSocket;

/**
 * WebSockets:
 * Real-time, bi-directional communication.
 */
@SpringBootApplication
@EnableWebSocket
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}

/**
 * Example Handler:
 * 
 * public class MyHandler extends TextWebSocketHandler {
 *     @Override
 *     public void handleTextMessage(WebSocketSession session, TextMessage message) {
 *         // Send data back to the same client or everyone
 *         session.sendMessage(new TextMessage("Echo: " + message.getPayload()));
 *     }
 * }
 */
