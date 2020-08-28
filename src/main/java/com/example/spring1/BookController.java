package com.example.spring1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {

    @Autowired
    BookRepository bookRepository;

    @GetMapping("/books")
    public List<Book> getBooks(){
        return bookRepository.findAll();
    }

    @RequestMapping(value = "/books",method = RequestMethod.POST)
    public void insertBook(@RequestBody Book book){
        bookRepository.save(book);
    }

    @GetMapping("/bookById")
    public Book getBookById(@RequestParam(value ="id") int id){
        Optional<Book> result=bookRepository.findById(id);
        return (Book)result.get();
    }
    @GetMapping("/bookById/{id}")
    public Book getBookByPathParam(@PathVariable int id){
        Optional<Book> result=bookRepository.findById(id);
        return (Book)result.get();
    }

}

