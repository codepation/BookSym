package com.example.back.service;

import com.example.back.entity.Book;
import com.example.back.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    BookMapper bookMapper;



    public List<Book> getbook(){
        return bookMapper.getallBook();
    }

    public String addBook(Book book){
        int r = bookMapper.insertBook(book);
        if (r>=1){
            return "sussecc";
        }
        return "fails";
    }

    public String deleteBookByid(Integer id){
        int r = bookMapper.deleteBookById(id);
        if (r>=1){
            return "sussecc";
        }
        return "fails";
    }

    public String updateBookByid(Book book){
        int r = bookMapper.updateBookById(book);
        if (r>=1){
            return "sussecc";
        }
        return "fails";
    }

    public Book findbookByid(Integer id){
        return bookMapper.findeBookById(id);
    }

}
