package com.example.back.controller;

import com.example.back.entity.Book;
import com.example.back.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    BookService bookService;

    @GetMapping("/getbook")
    public List<Book> getbook(){
        return bookService.getbook();
    }

    @PostMapping("/addbook")
    public String addbook(@RequestBody Book book){
        return bookService.addBook(book);
    }

    @DeleteMapping("/deleteBook/{id}")
    public String deleteBookById(@PathVariable Integer id){
        return bookService.deleteBookByid(id);
    }

    @PutMapping("/updatebook")
    public String updatebookByid(@RequestBody Book book){
        return bookService.updateBookByid(book);
    }

    @GetMapping("/findebookById")
    public Book findbookById(@RequestParam Integer id){
        return bookService.findbookByid(id);
    }

//    @GetMapping("/insertbook")
//    public String insertBook(int id,String name,String press,String author,double price){return bookService.insertBook(id,name,press,author,price);}
}
