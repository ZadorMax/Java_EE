package com.example.demo;

import com.example.demo.Book;
import com.example.demo.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
public class TBookController {

    private final BookService bookService;


    @GetMapping("/book/{isbn}")
    public String getBookByIsbn(@PathVariable String isbn, @ModelAttribute Book book, Model model) {

        model.addAttribute("book", bookService.findByIsbn(isbn));
        return "book";
    }

    @RequestMapping("/")
    public String index() {
        return "index";
    }
}