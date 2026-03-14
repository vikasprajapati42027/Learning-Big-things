package com.example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

class NotFoundException extends RuntimeException {
    public NotFoundException(String msg) { super(msg); }
}

@RestController
@RequestMapping("/items")
class ItemController {
    @GetMapping("/{id}")
    public String getItem(@PathVariable int id) {
        if (id > 10) throw new NotFoundException("Item " + id + " does not exist!");
        return "Item: " + id;
    }
}

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleNotFound(NotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
            .body(Map.of("error", ex.getMessage(), "status", 404));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> handleGeneral(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body(Map.of("error", "Something went wrong", "details", ex.getMessage()));
    }
}
