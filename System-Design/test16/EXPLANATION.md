# Test 16: Microservices Deployment Flow

## Simple Explanation
How does code go from your laptop to a running service? 

## The Standard Flow
1. **GitHub**: You push code.
2. **CI Pipeline**: Build JAR → Run Tests.
3. **Docker Registry**: Build Docker Image → Push to Docker Hub or AWS ECR.
4. **Platform**: 
   - **K8s**: `kubectl set image deployment/user-service user-service:v2`
   - **AWS Lambda**: Upload Zip or Image.

## Environment Separation
- **Dev**: Unstable, for developer testing.
- **Staging**: Identical to production, for QA testing.
- **Production**: Live for users.

## Config Management
Never put secrets in Docker images! 
- Use **Kubernetes Secrets**.
- Use **AWS Secrets Manager**.
- Use **Environment Variables**.

## Monitoring
After deployment, check **Grafana** (CPU/RAM) and **Kibana** (Logs) to ensure nothing is crashing.
