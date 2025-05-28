package com.demo.mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.mvc.entity.Book;
import com.demo.mvc.repo.BookRepo;

@Service
public class BookService {

    @Autowired
    private BookRepo bookRepo;

    public List<Book> getAll() {
        return bookRepo.findAll();
    }

    public Book getId(int id) {
        return bookRepo.findById(id).orElse(null);
    }

    public String saveBook(Book book) {
        bookRepo.save(book);
        return "Book saved successfully";
    }

    public String updateBook(Book book, int id) {
        Book existingBook = bookRepo.findById(id).orElse(null);
        if (existingBook != null) {
            book.setId(id); 
            bookRepo.save(book);
            return "UPDATED";
        } else {
            return "NOT_FOUND";
        }
    }

    public boolean deleteBook(int id) {
        if (bookRepo.existsById(id)) {
            bookRepo.deleteById(id);
            return true;
        }
        return false;
    }
}
