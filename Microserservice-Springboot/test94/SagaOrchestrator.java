package com.example.saga;

import org.springframework.stereotype.Service;

@Service
public class SagaOrchestrator {

    public void startTransaction() {
        System.out.println("Orchestrator: Starting Order Flow.");
        try {
            // 1. Call Inventory
            System.out.println("Orchestrator: Calling Inventory Service...");
            // 2. Call Payment
            System.out.println("Orchestrator: Calling Payment Service...");
        } catch (Exception e) {
            System.out.println("Orchestrator: Failure detected! Running Compensation logic to undo steps.");
        }
    }
}
