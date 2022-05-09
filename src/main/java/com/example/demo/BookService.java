package com.example.demo;

import com.example.demo.Book;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {
    List<Book> books = new ArrayList<>();

    public void add(Book book) {
        books.add(book);
    }

    public List<Book> getAll() {
        return books;
    }

    public List<Book> findByNameIsbn(String name, String isbn) {
        return books.stream()
                .filter(book -> ((book.getIsbn().contains(isbn)) || book.getName().contains(name)))
                .collect(Collectors.toList());
    }
}