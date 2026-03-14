# DevOps Mastery: Microservice Orchestration

## 🏢 1. Services
1. **Employee Service**: Handles payroll and staff data.
2. **Department Service**: Handles org-unit metadata.

## 🛳️ 2. Docker Execution
```bash
# Build Employee
docker build -t employee:v1 ./employee-service
# Build Department
docker build -t department:v1 ./department-service
```

## ☸️ 3. Kubernetes Execution
```bash
# Deploy the interaction stack
kubectl apply -f k8s/office-apps.yaml
```
