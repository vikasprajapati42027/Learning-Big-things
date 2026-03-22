# Online Code Execution Microservice (test9)

Spring Boot 3.2.x + Docker-based sandbox to compile/run user code (Java/Python demo).

## Prerequisites
- Java 17, Maven 3.9+
- Docker engine available locally (used for sandboxing)

## Run
```bash
cd java-backend-project/test9
mvn spring-boot:run
```
App listens on port 8500.

## API
`POST /api/execute`
```json
{
  "language": "java",           // or "python"
  "source": "public class Main { public static void main(String[] args){ System.out.println(1+1); } }",
  "stdin": "",                  // optional
  "timeLimitSeconds": 5          // optional (default 5)
}
```
Response:
```json
{
  "success": true,
  "exitCode": 0,
  "stdout": "2\n",
  "stderr": "",
  "message": "done"
}
```

## Sandbox approach
- Per request a temp workspace is mounted read-only into a short-lived Docker container.
- Network disabled, CPU limited, memory capped to 256 MB, time limited via process wait.
- Java: `openjdk:17-slim` compile then run `Main`.
- Python: `python:3.11-slim` executes script.

## Notes
- For production, add image caching, stronger timeouts via cgroups, file size limits, and language whitelisting.
- If Docker is unavailable, responses will contain an IO error; integrate remote sandbox or Kubernetes jobs as needed.
