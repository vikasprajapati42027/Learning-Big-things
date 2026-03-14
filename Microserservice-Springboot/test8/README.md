# Test 8: Distributed Configuration (Spring Cloud Config)

Manage all your service settings in one central place.

## The Problem:
If you have 100 microservices and you need to change a database password, you have to:
1. Open 100 projects.
2. Change 100 `application.properties` files.
3. Re-build and Re-deploy 100 services.
This is impossible in a large company.

## The Solution (Config Server):
We create a **Central Config Server**. All settings for ALL services are stored in one place (folders or a Git repository).

### How it works:
1. **Config Server**: Runs on port **9292**. It holds the properties for all services.
2. **Microservices (Clients)**: When they start up, they say: "I am 'department-service'. Hey Config Server, give me my settings!"
3. **Response**: The Config Server sends the properties, and the microservice configures itself.

---

## 🔑 Key Setup:
1. **The Server**: Added `@EnableConfigServer` and pointed it to the `config-repo` folder.
2. **The Client**: Added `spring-cloud-starter-config` and set `spring.config.import=...`.

## How to test this:
1. Start **Config Server** (Port 9292) first.
2. Open `http://localhost:9292/department-service/default`. You will see the JSON of its settings!
3. Start the **Department Service**.
4. Even though its `application.properties` is almost empty, it will start on Port **8081** and connect to the database because it fetched those settings from the Config Server!

---

## Why is this important?
You can now change any setting (like a timeout or a feature flag) in the central repository while the system is running, and the services can see the change without you having to recompile the code!
