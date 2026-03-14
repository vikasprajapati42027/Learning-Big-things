# Test 74: Prompt Engineering

Don't just send strings; use Templates.

## Why Templates?
- **DRY (Don't Repeat Yourself)**: Define the instruction once, swap variables many times.
- **Safety**: Prevents "Prompt Injection" (users trying to trick the AI).
- **Versioning**: You can change the "Tone" of your AI in one central file.

## System vs User Message:
- **System**: "You are a helpful assistant" (The personality).
- **User**: "Tell me a joke" (The request).
Spring AI makes it easy to split these.
