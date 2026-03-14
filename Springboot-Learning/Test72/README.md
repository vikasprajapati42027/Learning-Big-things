# Test 72: Spring AI (Integration)

Connecting to the brain of the AI.

## Ollama:
Ollama allows you to run models like **Llama 3** or **Mistral** on your own laptop. Spring AI has built-in support for it.

## ChatClient:
The main bean you use to call the AI.
- `.call(prompt)`: Synchronous call.
- `.stream(prompt)`: Returns a `Flux` for "typing effect" in your UI.

## Tokens:
LLMs don't read words, they read **Tokens**. Every call costs tokens. Spring AI helps you track how many tokens were used in each request.
