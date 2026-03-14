package com.example.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class StandardResponseController {

    record ApiResponse<T>(boolean success, String message, T data) {}

    @GetMapping("/product/{id}")
    public ResponseEntity<ApiResponse<Map<String, Object>>> getProduct(@PathVariable int id) {
        if (id <= 0) {
            return ResponseEntity.badRequest()
                .body(new ApiResponse<>(false, "Invalid ID", null));
        }
        var product = Map.<String, Object>of("id", id, "name", "Laptop", "price", 999.99);
        return ResponseEntity.ok(new ApiResponse<>(true, "Product found", product));
    }
}
