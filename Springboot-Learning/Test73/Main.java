package Test73;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * RAG (Retrieval-Augmented Generation):
 * Feeding your own private data (PDFs, DB) to the AI 
 * so it can answer specific questions.
 */
@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}

/**
 * Vector Databases supported by Spring AI:
 * - Pinecone
 * - Milvus
 * - PGVector (Postgres)
 * - Chroma
 * - Redis
 */
