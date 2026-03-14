package com.example.vector;

import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.ai.document.Document;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class KnowledgeService {

    private final VectorStore vectorStore;

    public KnowledgeService(VectorStore vectorStore) {
        this.vectorStore = vectorStore;
    }

    public void storeKnowledge(String content) {
        // Convert text to Embeddings (numbers) and store in Vector DB
        vectorStore.add(List.of(new Document(content)));
    }

    public List<Document> searchKnowledge(String query) {
        // Search by "Meaning" (Semantic Search), not just keywords
        return vectorStore.similaritySearch(query);
    }
}
