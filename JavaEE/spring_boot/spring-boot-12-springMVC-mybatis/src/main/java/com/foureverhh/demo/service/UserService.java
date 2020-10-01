package com.foureverhh.demo.service;

import com.foureverhh.demo.pojo.User;

import java.util.*;

public interface UserService {
    int insertUser(User user);
    List<User> showAll();
    User findUserById(Integer id);
    int updateUser(User user);
    int deleteUserById(Integer id);
}
