package com.example.back.mapper;

import com.example.back.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.redis.connection.stream.StreamInfo;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("select * from user")
    List<User> getAlluser();
    @Select("select * from user where username=#{username}")
    User getUserByName(String username);

    @Select("select * from user where password=#{password}")
    User getUserByPass(String password);

    @Insert("insert into user(username,password)values(#{username},#{password})")
    int register(String username,String password);


}
