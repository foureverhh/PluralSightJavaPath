package com.foureverhh.dao;

import com.foureverhh.pojo.User;

import java.util.List;

public interface UserDao {
    void insertUser(User user);
    void updateUser(User user);
    void deleteUser(User user);
    User selectUserById(Integer user);
    List<User> selectUserByName(String name);
    List<User> selectUserByNameInSql(String name);
    List<User> selectUserByNameInByCriteria(String name);
}
