package com.example.saga;

import org.springframework.stereotype.Service;

/**
 * SAGA Orchestration: A central manager controls the flow.
 */
@Service
public class SagaOrchestrator {

    public void createOrderWorkflow() {
        System.out.println("MANAGER: Starting Order Workflow...");
        
        callPayment();
        callInventory();
        callShipping();
        
        System.out.println("MANAGER: Workflow Success!");
    }

    private void callPayment() { System.out.println("Step 1: Payment Charged"); }
    private void callInventory() { System.out.println("Step 2: Inventory Reserved"); }
    private void callShipping() { System.out.println("Step 3: Shipping Scheduled"); }
}
