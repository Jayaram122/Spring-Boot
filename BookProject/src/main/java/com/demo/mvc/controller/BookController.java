package com.demo.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.demo.mvc.entity.Book;
import com.demo.mvc.service.BookService;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("/create")
    public ResponseEntity<String> createBook(@RequestBody Book book) {
        if (book.getBookName() == null || book.getAuthhorName() == null || book.getBookPrice() <= 0) {
            return ResponseEntity.badRequest().body("Invalid book data");
        }
        return ResponseEntity.ok(bookService.saveBook(book));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> books = bookService.getAll();
        if (books.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(books);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getBookById(@PathVariable int id) {
        Book book = bookService.getId(id);
        if (book == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(book);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateBook(@RequestBody Book book, @PathVariable int id) {
        String result = bookService.updateBook(book, id);
        if (result.equals("UPDATED")) {
            return ResponseEntity.ok("Book updated successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable int id) {
        boolean deleted = bookService.deleteBook(id);
        if (deleted) {
            return ResponseEntity.ok("Book deleted successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
