package com.foureverhh.demo.mapper;

import com.foureverhh.demo.pojo.User;

import java.util.List;

public interface UserMapper {
    Integer addUser(User user);
    List<User> selectAll();
    User selectUserById(Integer id);
    int updateUser(User user);
    int deleteUserById(Integer id);
}
