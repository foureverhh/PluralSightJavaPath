package service.impl;

import mapper.UserMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import pojo.User;
import service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserMapper userMapper;
    @Value("${my.demo}")
    private String test;
    @Value("${my.number}")
    private int number;

    public UserMapper getUserMapper() {
        return userMapper;
    }

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public User login(User user) {
        return userMapper.selUserByNameAndPwd(user);
    }

    @Override
    public List<User> selAll() {
        System.out.println("test is " +test);
        return userMapper.selAll();
    }

    @Override
    public int insert(User user) {
        return 0;
    }
}
