package com.example.db;
import jakarta.persistence.*;
import org.springframework.stereotype.Service;
import java.util.List;

@Entity class Author { @Id Long id; String name;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "author")
    List<Book> books;
}
@Entity class Book { @Id Long id; String title;
    @ManyToOne Author author;
}

@Service
public class Test5_NPlus1 {
    @PersistenceContext EntityManager em;

    // BAD: N+1 — 1 query for authors + N queries for each author's books
    public void badExample() {
        List<Author> authors = em.createQuery("SELECT a FROM Author a", Author.class).getResultList();
        for (Author a : authors) {
            System.out.println(a.books.size()); // Each access = 1 extra SQL query!
        }
    }

    // GOOD: JOIN FETCH — loads everything in a SINGLE query
    public void goodExample() {
        List<Author> authors = em.createQuery(
            "SELECT DISTINCT a FROM Author a JOIN FETCH a.books", Author.class
        ).getResultList();
        for (Author a : authors) {
            System.out.println(a.books.size()); // No extra SQL!
        }
    }
}
