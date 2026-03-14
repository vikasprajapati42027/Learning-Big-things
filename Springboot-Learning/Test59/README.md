# Test 59: Spring Native (GraalVM)

From "Startup in 15 seconds" to "Startup in 0.1 seconds".

## What is Spring Native?
Traditionally, Java compiles to bytecode. Spring Native uses **GraalVM** to compile your Java code directly into a **Native Binary** (like an .exe or .bin).

## Benefits:
1. **Instant Startup**: Perfect for Serverless (AWS Lambda).
2. **Lower Memory**: USes much less RAM because everything is pre-calculated.
3. **Small Footprint**: You don't even need a JVM on the server to run it.

## Tradeoffs:
- **Build Time**: Compiling to native can take several minutes.
- **Reflection**: Some libraries might need extra configuration to work.
