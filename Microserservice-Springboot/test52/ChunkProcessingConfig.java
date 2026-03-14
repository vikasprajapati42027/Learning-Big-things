package com.example.batch;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Configuration;
import java.util.List;

@Configuration
public class ChunkProcessingConfig {

    public ItemReader<String> reader() {
        return () -> "Raw Data Line";
    }

    public ItemProcessor<String, String> processor() {
        return String::toUpperCase;
    }

    public ItemWriter<String> writer() {
        return items -> System.out.println("Writing Chunk of size: " + items.size());
    }
}
// Note: This would be wired into a Step with .chunk(100)
