package com.example.functions;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import java.util.function.Function;
import java.util.function.Supplier;

@Component
public class LogicFunctions {

    @Bean
    public Function<String, String> process() {
        return value -> "Processed: " + value.toUpperCase();
    }

    @Bean
    public Supplier<String> status() {
        return () -> "Serverless function is healthy!";
    }
}
