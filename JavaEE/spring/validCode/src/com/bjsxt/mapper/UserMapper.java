package com.bjsxt.mapper;

import com.bjsxt.pojo.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {
    @Select("select * from user")
    List<User> selAll();

    @Select("select * from user where username=#{username} and password=#{password}")
    User findUserByUserNameAndPassword(User user);
}
