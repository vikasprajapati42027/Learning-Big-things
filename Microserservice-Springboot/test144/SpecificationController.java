package com.example.specification;

import jakarta.persistence.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Entity
class Vehicle {
    @Id @GeneratedValue
    private Long id;
    private String brand;
    private String type; // "SUV", "Sedan", etc.
    private double price;

    public Long getId() { return id; }
    public String getBrand() { return brand; }
    public String getType() { return type; }
    public double getPrice() { return price; }
}

interface VehicleRepository extends JpaRepository<Vehicle, Long>, JpaSpecificationExecutor<Vehicle> {}

@RestController
@RequestMapping("/vehicles")
public class SpecificationController {

    private final VehicleRepository repo;
    SpecificationController(VehicleRepository r) { this.repo = r; }

    @GetMapping("/search")
    public List<Vehicle> search(
            @RequestParam(required = false) String type,
            @RequestParam(required = false) Double maxPrice) {

        Specification<Vehicle> spec = Specification.where(null);
        if (type != null) {
            spec = spec.and((root, q, cb) -> cb.equal(root.get("type"), type));
        }
        if (maxPrice != null) {
            spec = spec.and((root, q, cb) -> cb.lessThanOrEqualTo(root.get("price"), maxPrice));
        }
        return repo.findAll(spec);
    }
}
