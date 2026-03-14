package com.example.async;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import java.util.concurrent.CompletableFuture;

@Service
public class AsyncEmailService {

    @Async
    public CompletableFuture<String> sendEmail(String to) throws InterruptedException {
        System.out.println("[THREAD: " + Thread.currentThread().getName() + "] Sending email to " + to);
        Thread.sleep(3000); // Simulating slow email
        return CompletableFuture.completedFuture("Email sent to " + to);
    }
}
