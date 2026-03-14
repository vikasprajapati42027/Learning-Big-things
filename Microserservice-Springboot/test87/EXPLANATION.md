# Test 87: Spring Boot Admin Server

A beautiful UI dashboard for all your Spring Boot services.

## Key Files:
- `AdminServerApplication.java`: Main entry with `@EnableAdminServer`.
- `EXPLANATION.md`: Why you need a central dashboard for logs and metrics.

## Concept:
Admin Server is a web application that sits on top of your other microservices. It pulls their Actuator endpoints and presents them as a nice UI where you can see:
- Visual heap dump analysis.
- Live log file viewing.
- Thread details.
- Health status of all registered instances.
