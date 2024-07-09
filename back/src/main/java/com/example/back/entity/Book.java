package com.example.back.entity;

import lombok.Data;

@Data
public class Book {
   private Integer bookId;
   private String bookName;//和数据库的列名相同
   private String bookPress;
   private String bookAuthor;
   private String bookPrice;
   private String bookIsbn;
}
