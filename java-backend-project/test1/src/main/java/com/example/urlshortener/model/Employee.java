package com.example.urlshortener.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.Instant;

@Entity
@Table(name = "employees", indexes = {
        @Index(name = "idx_employee_email", columnList = "email", unique = true)
})
@Data
@EqualsAndHashCode(of = "id")
@ToString
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 255)
    private String name;

    @Column(nullable = false, unique = true, length = 320)
    private String email;

    @Column(nullable = false, length = 128)
    private String department;

    @Column(nullable = false, updatable = false)
    private Instant createdAt = Instant.now();
}
