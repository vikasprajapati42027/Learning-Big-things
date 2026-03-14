package com.example.webhook;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
public class WebhookController {

    @PostMapping("/webhook/payment")
    public String receiveWebhook(@RequestBody Map<String, Object> payload) {
        String event = (String) payload.get("event");
        System.out.println("Webhook received: " + event);

        if ("payment.success".equals(event)) {
            System.out.println("Order Confirmed! Triggering fulfillment...");
        }
        return "Webhook Acknowledged";
    }
}
