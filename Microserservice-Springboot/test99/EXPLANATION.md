# Test 99: CI/CD Pipeline (GitHub Actions)

Automating the Build, Test, and Deploy cycle.

## Key Files:
- `EXPLANATION.md`: The journey of code from `git push` to `production`.

## Steps in a Microservice Pipeline:
1.  **Checkout**: Pull latest code.
2.  **Compile & Test**: Run Maven/JUnit tests.
3.  **Build Image**: Create a Docker image.
4.  **Push Image**: Save to Docker Hub or AWS ECR.
5.  **Deploy**: Update Kubernetes or AWS directly.

This ensures that only high-quality, tested code ever reaches your users.
