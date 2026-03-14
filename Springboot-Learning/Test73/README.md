# Test 73: RAG (Your own AI)

LLMs know about the world up to a certain date. **RAG** allows them to know about YOUR data.

## The Flow:
1. **Embedding**: Convert your text into numbers (Vectors).
2. **Vector Store**: Save these numbers in a special database.
3. **Retrieval**: When a user asks a question, find the most similar text in your Vector Store.
4. **Augment**: Send the question + the found text to the AI.
5. **Generate**: AI answers based on YOUR data!

This is how companies build internal "Knowledge Bots".
