package com.example.cdc;

import org.springframework.stereotype.Service;

@Service
public class DebeziumSimulation {

    public void onDatabaseChange(String event) {
        // Logic for Change Data Capture
        System.out.println("Debezium detected a SQL INSERT. Updating Kafka and Redis automatically...");
    }
}
