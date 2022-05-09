package com.example.demo;

import com.example.demo.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookService {

    private final EntityManager entityManager;
    List<Book> books = new ArrayList<>();

//    public void add(Book book) {
//        books.add(book);
//    }

    @Transactional
    public Book add(Book book) {
        return entityManager.merge(book);
    }

//    public List<Book> getAll() {
//        return books;
//    }
    public List<Book> getAll() {
        return entityManager.createQuery("SELECT book FROM Book book",Book.class)
                .getResultList();
    }

//    public List<Book> findByNameIsbn(String name, String isbn) {
//        return books.stream()
//                .filter(book -> ((book.getIsbn().contains(isbn)) || book.getName().contains(name)))
//                .collect(Collectors.toList());
//    }

    public Book findByIsbn(String isbn) {
        return entityManager.createQuery(
                        "SELECT book FROM Book book WHERE book.isbn = :isbn", Book.class)
                .setParameter("isbn", isbn)
                .getSingleResult();
    }

    public List<Book> findByNameIsbn(String name, String isbn, String author) {
        return entityManager.createQuery(
                        "SELECT book FROM Book book WHERE " +
                                "(book.isbn = :isbn) OR " +
                                "(book.name = :name) OR " +
                                "(book.author = :author)",
                        Book.class)
                .setParameter("isbn", isbn)
                .setParameter("name", name)
                .setParameter("author", author)
                .getResultList();
    }
}