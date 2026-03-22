package com.example.product.controller;

import com.example.product.model.Product;
import com.example.product.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product create(@RequestBody Product product) {
        return productService.create(product);
    }

    @GetMapping
    public List<Product> list() {
        return productService.findAll();
    }
}
