package com.example.pagination;

import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.*;
import jakarta.persistence.*;

@Entity
class Post {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    public Post() {}
    public Post(String title) { this.title = title; }
    public Long getId() { return id; }
    public String getTitle() { return title; }
}

interface PostRepository extends JpaRepository<Post, Long> {}

@RestController
@RequestMapping("/posts")
public class PaginatedController {

    private final PostRepository repo;
    PaginatedController(PostRepository repo) { this.repo = repo; }

    @GetMapping
    public Page<Post> getPosts(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return repo.findAll(pageable);
    }
}
