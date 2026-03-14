package com.example.hateoas;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.web.bind.annotation.*;
import jakarta.persistence.*;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Entity
class Order {
    @Id @GeneratedValue
    private Long id;
    private String item;
    public Long getId() { return id; }
    public String getItem() { return item; }
}

interface OrderRepo extends JpaRepository<Order, Long> {}

@RestController
@RequestMapping("/orders")
public class HateoasController {

    private final OrderRepo repo;
    HateoasController(OrderRepo r) { this.repo = r; }

    @GetMapping("/{id}")
    public EntityModel<Order> getOrder(@PathVariable Long id) {
        Order order = repo.findById(id).orElseThrow();
        return EntityModel.of(order,
            linkTo(methodOn(HateoasController.class).getOrder(id)).withSelfRel(),
            Link.of("/orders/" + id + "/cancel").withRel("cancel"));
    }
}
