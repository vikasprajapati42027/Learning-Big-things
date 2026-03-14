# Test 22: Spring Boot DevTools

Save time by avoiding manual restarts.

## Key Benefit:
It uses two classloaders. One for libraries (which don't change) and one for your code. When your code changes, it only restarts the "Restart Classloader", which is much faster than a full cold start.

## Remote Update:
You can even use DevTools to push code changes to a remote server running in debug mode! (Not recommended for production).
