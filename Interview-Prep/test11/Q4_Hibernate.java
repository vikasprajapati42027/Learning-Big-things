/**
 * INTERVIEWER: Hibernate Topic 4.
 * CANDIDATE: Advanced Hibernate explanation and code.
 */
import java.util.*;

public class Q4_Hibernate {
    static class Author {
        private final String name;
        private final List<Book> books = new ArrayList<>();

        Author(String name) {
            this.name = name;
        }

        void addBook(Book book) {
            books.add(book);
            book.setAuthor(this);
        }

        @Override
        public String toString() {
            return "Author{" + name + ", books=" + books.size() + "}";
        }
    }

    static class Book {
        private final String title;
        private Author author;

        Book(String title) {
            this.title = title;
        }

        void setAuthor(Author author) {
            this.author = author;
        }

        @Override
        public String toString() {
            return "Book{" + title + "}";
        }
    }

    public static void main(String[] args) {
        Author author = new Author("Carl");
        Book book1 = new Book("Hibernate Basics");
        Book book2 = new Book("Advanced Mapping");
        author.addBook(book1);
        author.addBook(book2);
        System.out.println(author + " authored: " + author.books);
    }
}
