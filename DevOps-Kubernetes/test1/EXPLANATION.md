# Test 1: Basic Dockerization

## �� 1. Docker Concept
Take a Java file, package it with its OS and JDK, and run it anywhere.

## 🛠️ 2. How to Run
```bash
# 1. Build the Image
docker build -t employee-service:v1 .

# 2. Run the Container
docker run employee-service:v1
```
