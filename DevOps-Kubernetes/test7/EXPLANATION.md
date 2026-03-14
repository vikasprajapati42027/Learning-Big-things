# Test Multi-Service Architecture

## 🚀 1. Docker Run
```bash
# Start both services
docker-compose up --build
```

## ☸️ 2. Kubernetes Run
```bash
# 1. Build images for local K8s (if using minikube)
eval $(minikube docker-env)
docker build -t employee:latest ./employee-service
docker build -t department:latest ./department-service

# 2. Deploy
kubectl apply -f k8s/deployment.yaml
```
