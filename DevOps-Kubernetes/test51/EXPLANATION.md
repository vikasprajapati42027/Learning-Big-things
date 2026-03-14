# Test 51: The ENCYCLOPEDIA of Docker Commands

A 360-degree guide to Docker, from a developer's first `run` to an architect's `prune`.

---

## �� 1. Image Management (The Blueprints)
| Command | Description |
| :--- | :--- |
| `docker build -t app:v1 .` | Build an image from Dockerfile. |
| `docker images` | List all local images. |
| `docker pull <image>` | Download an image from Docker Hub. |
| `docker push <image>` | Upload an image to a registry. |
| `docker rmi <id>` | Remove an image. |
| `docker rmi $(docker images -q)` | **Batch**: Delete all local images. |
| `docker tag source target` | Create a tag/alias for an existing image. |
| `docker history <image>` | See the layers and size of an image. |
| `docker save -o app.tar <img-id>` | Save image to a tar file. |
| `docker load -i app.tar` | Load image from a tar file. |
| `docker image prune` | Remove all dangling/unused images. |

---

## 🟡 2. Container Lifecycle (The Running Instances)
| Command | Description |
| :--- | :--- |
| `docker run -it --name test app` | Run interactively (Terminal attached). |
| `docker run -d --name test app` | Run in background (Detached). |
| `docker run -p 8080:80 app` | Map Host port 8080 to Container port 80. |
| `docker run -v /host:/cont app` | Mount a local directory into the container. |
| `docker run --env KEY=VAL app` | Pass environment variables. |
| `docker run --restart always app` | Automatically restart if it crashes. |
| `docker start/stop/restart <id>` | Control container status. |
| `docker pause/unpause <id>` | Freeze/unfreeze the container processes. |
| `docker rm -f <id>` | Forcefully delete a running container. |
| `docker wait <id>` | Block until a container stops. |
| `docker rename <old> <new>` | Rename a container. |

---

## 🔵 3. Debugging & Monitoring (The Doctor's Tools)
| Command | Description |
| :--- | :--- |
| `docker ps` | List running containers. |
| `docker ps -a` | List ALL containers (stopped/exited). |
| `docker logs -f <id>` | Follow real-time output. |
| `docker logs --tail 100 <id>` | See only the last 100 lines. |
| `docker top <id>` | List processes running inside the container. |
| `docker stats` | Live CPU, Memory, and Network usage per container. |
| `docker inspect <id>` | Get the full JSON metadata of a container. |
| `docker diff <id>` | See which files changed inside the container since start. |
| `docker port <id>` | See which ports are mapped. |
| `docker exec -it <id> sh` | Open a shell inside a running container. |
| `docker cp <src> <dest>` | Copy files in/out (e.g., `docker cp log.txt my-app:/tmp`). |

---

## 🟠 4. Networking & Volumes (The Plumber's Tools)
| Command | Description |
| :--- | :--- |
| `docker network ls` | List all virtual networks. |
| `docker network create <n>` | Create a bridge or overlay network. |
| `docker network inspect <n>` | See which containers are on which network. |
| `docker network connect <n> <id>` | Add a running container to a network. |
| `docker volume ls` | List all persistent storage volumes. |
| `docker volume create <v>` | Create a named volume for DB data. |
| `docker volume inspect <v>` | See exact mount point on host. |
| `docker volume rm <v>` | Delete a volume (data is lost!). |

---

## 🔴 5. Advanced & System (The Architect's Mastery)
| Command | Description |
| :--- | :--- |
| `docker system df` | See how much disk space Docker is eating. |
| `docker system prune -a --volumes` | **Nuke Everything**: Clean all cache, images, and data. |
| `docker commit <id> my-new-img` | Save the current state of a container as a NEW image. |
| `docker events --since 1h` | Get a live stream of what the Docker daemon did. |
| `docker login` | Authenticate with Docker Hub or Private Registry. |
| `docker buildx build ...` | Build multi-architecture images (AMD64, ARM64). |
| `docker export <id> > app.tar` | Export container filesystem (not the image). |
| `docker import app.tar` | Create an image from a filesystem export. |

---

## 🍱 6. Basic Workflow Example
```bash
# Workflow: Develop -> Package -> Run
docker build -t employee-service:1.0 .
docker run -d -p 9090:8080 --name emp-v1 employee-service:1.0
docker logs -f emp-v1
# If bug found:
docker exec -it emp-v1 sh
ls -la /app
# Cleanup
docker stop emp-v1 && docker rm emp-v1
```
