package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.demo.BookService;
import java.util.ArrayList;
import java.util.List;

@RestController
public class BookController {

   // List<Book> books = new ArrayList<>();
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity<List<Book>> saveBook(
            @RequestBody final Book book
    ) {
        bookService.add(book);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(bookService.getAll());
    }

    @RequestMapping(value = "/find", method = RequestMethod.POST)
    public ResponseEntity<List<Book>> findBooks(
            @RequestBody final Book book
    ) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(bookService.findByNameIsbn(book.getName(),book.getIsbn()));
    }

    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public ResponseEntity<List<Book>> getAll() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(bookService.getAll());
    }


//    @RequestMapping(value = "/books-list", method = RequestMethod.GET)
//    public String booksList(Model model) {
//        model.addAttribute("books", books);
//        return "books-list";
//    }
//
//    @RequestMapping(value = "/book", method = RequestMethod.GET)
//    public String saveBook(){
//        return "books-form";
//    }
//
//    @RequestMapping(value = "/add-books", method = RequestMethod.POST)
//    public String listBooks(@ModelAttribute Book book){
//        books.add(book);
//        return "redirect:/books-list";
//    }
}
