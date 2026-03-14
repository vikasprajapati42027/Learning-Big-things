package com.example.departmentservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class DepartmentApplication {
	public static void main(String[] args) {
		SpringApplication.run(DepartmentApplication.class, args);
	}
}
// Note: Entity, Repo, Controller and Service classes are standard (same as test3)
