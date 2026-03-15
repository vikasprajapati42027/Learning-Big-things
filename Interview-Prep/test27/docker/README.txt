Docker workspace for Interview Prep Module 27 covers containerizing Java services.
- Build image: `docker build -t frontend-microservice ./docker`
- Run container: `docker run --rm -p 8080:8080 frontend-microservice`
- Inspect: `docker ps --filter ancestor=frontend-microservice`
- Logs and cleanup shown in `docker/docker-commands.txt`.
