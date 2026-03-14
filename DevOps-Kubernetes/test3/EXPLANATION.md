# Test 3: Kubernetes Service

## 🌐 1. Concept
A Deployment is internal. A **Service** provides a stable IP/DNS to access those pods from outside.

## 🛠️ 2. How to Run
```bash
# 1. Apply Service
kubectl apply -f service.yaml

# 2. Get External IP
kubectl get svc
```
