package com.example.back;

import com.example.back.entity.Book;
import com.example.back.entity.User;
import com.example.back.mapper.BookMapper;
import com.example.back.mapper.UserMapper;
import com.example.back.service.BookService;
import com.example.back.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class BackApplicationTests {

	@Autowired
	UserMapper userMapper;

	@Autowired
	BookMapper bookMapper;
//	@Test
//	void findbook(){
//		System.out.println(bookMapper.BookById(1));
//	}
//
//	@Autowired
//	BookService bookService;
//	@Test
//	void findallBook(){
//		System.out.println(bookService.findAllBookById(1));
//	}
//
//	@Test
//	void insert(){
//		int book = bookMapper.insertbook(1,"zhang","zhang","zhang",12.3);
//
//		System.out.println(book);
//	}
//
//
//	@Autowired
//	RedisTemplate<String,Object> redisTemplate;
//
//
//	@Test
//	void redis(){
//		String key = "zhang";
//		String vakue = "nihoa";
//		redisTemplate.opsForValue().set(key,vakue);
//	}

	@Autowired
	UserService userService;

	@Autowired
	BookService bookService;

	@Test
	void register(){
		Book b = new Book();
		b.setBookName("zhang");
		b.setBookIsbn("sdf");
		b.setBookPrice("123");
		b.setBookAuthor("zhang");
		b.setBookPress("sdfsd");
	System.out.println(bookService.addBook(b));
	}
}
