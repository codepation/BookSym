package com.example.back.mapper;

import com.example.back.entity.Book;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BookMapper {
    @Select("select * from book")
    List<Book> getallBook();

    @Select("select * from book where book_id=#{id}")
    Book findeBookById(Integer id);

    @Update("update book set book_name=#{bookName},book_isbn=#{bookIsbn},book_press=#{bookPress},book_author=#{bookAuthor},book_price=#{bookPrice} where book_id=#{bookId}")
    int updateBookById(Book book);

    @Insert("insert into book(book_name,book_isbn,book_press,book_author,book_price)values(#{bookName},#{bookIsbn},#{bookPress},#{bookAuthor},#{bookPrice})")
    int insertBook(Book book);

    @Delete("delete from book where book_id = #{id}")
    int deleteBookById(Integer id);
    

    @Select("select book_id from book where book_name=#{bookName},book_isbn=#{bookIsbn},book_press=#{bookPress},book_author=#{bookAuthor},book_price=#{bookPrice};")
    Integer findebook_id(Book book);
}
