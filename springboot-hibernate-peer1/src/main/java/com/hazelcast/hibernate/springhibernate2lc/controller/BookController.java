package com.hazelcast.hibernate.springhibernate2lc.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hazelcast.hibernate.springhibernate2lc.persistence.Book;
import com.hazelcast.hibernate.springhibernate2lc.persistence.BookRepository;


@RestController
public class BookController {
	
    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/books")
    public Page<Book> getBooks(Pageable pageable) {
    	System.out.println("Getting Book Posted");
        return bookRepository.findAll(pageable);
    }
    
    @PostMapping("/books")
    public Book createBook(@RequestBody Book book) {
 
    	System.out.println("Book Posted");
        return bookRepository.save(book);
    }
    
    @GetMapping("/books/{bookId}")
    public Optional<Book> getBook(@PathVariable long bookId, @RequestBody Book book) {
    	 return bookRepository.findById(bookId);
    }
     
  
}
 