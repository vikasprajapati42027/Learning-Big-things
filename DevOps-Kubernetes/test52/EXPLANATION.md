# Test 52: The Master Kubernetes (K8s) Handbook

The most complete `kubectl` command reference for Senior DevOps Engineers.

---

## 🟢 1. Viewing Resources (The Eyes)
| Command | Description |
| :--- | :--- |
| `kubectl get pods -A` | List pods in ALL namespaces. |
| `kubectl get pods -o wide` | List pods with IP addresses and Node names. |
| `kubectl get pods -w` | Watch pods (real-time updates). |
| `kubectl get pods --show-labels` | Show labels attached to each pod. |
| `kubectl get svc/deploy/ingress` | View specific types of resources. |
| `kubectl get all` | Show everything in the current namespace. |
| `kubectl describe <type> <name>` | Show detailed "Events" (Why did it fail?). |
| `kubectl explain pod.spec` | Get documentation on any YAML field instantly. |

---

## 🟡 2. Operational Mastery (The Hands)
| Command | Description |
| :--- | :--- |
| `kubectl apply -f folder/` | Apply all YAMLs in a directory. |
| `kubectl create deploy <n> --image=img` | Create a deployment via CLI (no YAML needed). |
| `kubectl expose deploy <n> --port=80` | Create a Service for a deployment via CLI. |
| `kubectl delete pod <name> --force` | Kill a stuck pod instantly. |
| `kubectl edit <type> <name>` | Update live configuration in Vim/Nano. |
| `kubectl label pod <name> version=2` | Add a label to a running pod. |
| `kubectl annotate pod <name> desc=...` | Add non-identifying metadata to a pod. |

---

## 🔵 3. Debugging & Logs (The Ears)
| Command | Description |
| :--- | :--- |
| `kubectl logs <pod_name>` | View standard output logs. |
| `kubectl logs <pod_name> -c <cnt>` | View logs from a specific container in a multi-container pod. |
| `kubectl logs -p <pod_name>` | View logs from the PREVIOUS (crushed) instance. |
| `kubectl exec -it <pod_name> -- sh` | Terminal access into a pod. |
| `kubectl port-forward <pod> 8080:80` | Access a private pod on your local browser. |
| `kubectl cp <loc> <pod>:/path` | Copy a config or log file in/out of a pod. |
| `kubectl auth can-i create pod` | Check if your current user has permissions. |

---

## 🟠 4. Scaling & Rollouts (The Muscles)
| Command | Description |
| :--- | :--- |
| `kubectl scale deploy <n> --replicas=10` | Instant scaling to 10 instances. |
| `kubectl autoscale deploy <n> --max=5` | Set up a Horizontal Pod Autoscaler via CLI. |
| `kubectl rollout status deploy <n>` | Monitor a version update in progress. |
| `kubectl rollout history deploy <n>` | See a history of previous versions (Revision 1, 2, 3). |
| `kubectl rollout undo deploy <n>` | **Emergency**: Rollback to the previous version. |
| `kubectl rollout restart deploy <n>` | Force a rolling restart of all pods. |

---

## 🔴 5. Context & Configuration (The Brain)
| Command | Description |
| :--- | :--- |
| `kubectl config view` | See your current `.kube/config` (Clusters, Users). |
| `kubectl config current-context` | Which cluster am I talking to? |
| `kubectl config use-context <name>` | Switch between Dev, Staging, and Prod clusters. |
| `kubectl config set-context --ns=dev` | Set a default namespace so you don't need `-n dev`. |
| `kubectl api-resources` | List all supported resource types in the cluster. |
| `kubectl get nodes --show-labels` | See which nodes are for "GPU" or "CPU" workloads. |

---

## 🟣 6. Advanced Plumbing (The Architect's Secret)
| Command | Description |
| :--- | :--- |
| `kubectl get pods --field-selector status.phase=Running` | Filter pods by status. |
| `kubectl get pod <name> -o yaml` | **Export**: Get the current YAML of a live resource. |
| `kubectl top pod/node` | Show CPU/RAM usage (Check for leaks). |
| `kubectl cordon/uncordon <node>` | Mark a node as unschedulable (Maintenance mode). |
| `kubectl drain <node>` | Evict all pods from a node safely. |
| `kubectl proxy` | Open a local proxy to the K8s API server dashboard. |

---

## �� 7. Basic Workflow Example
```bash
# Workflow: Deploy -> Verify -> Scale
kubectl apply -f deployment.yaml
kubectl get pods -w
kubectl logs -f employee-pod-abc
# Scaling because of high traffic:
kubectl scale deployment office-stack --replicas=5
# Something went wrong? Rollback:
kubectl rollout undo deployment office-stack
```
