package com.controller;

import com.model.Books;
import com.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BooksController {
    @Autowired
    BooksService booksService;
    //creating a get mapping that retrieves all the books detail from the database
    @GetMapping("/book")
    private List<Books> getAllBooks()
    {
        return booksService.getAllBooks();
    }
    //creating a get mapping that retrieves the detail of a specific book
    @GetMapping("/book/{bookid}")
    private Books getBooks(@PathVariable("bookid") int bookid)
    {
        return booksService.getBooksById(bookid);
    }
    //creating a delete mapping that deletes a specified book
    @DeleteMapping("/book/{bookid}")
    private void deleteBook(@PathVariable("bookid") int bookid)
    {
        booksService.delete(bookid);
    }
    //creating post mapping that post the book detail in the database
    @PostMapping("/books")
    private int saveBook(@RequestBody Books books)
    {
        booksService.saveOrUpdate(books);
        return books.getBookid();
    }
    //creating put mapping that updates the book detail
    @PutMapping("/books")
    private Books update(@RequestBody Books books)
    {
        booksService.saveOrUpdate(books);
        return books;
    }
}
