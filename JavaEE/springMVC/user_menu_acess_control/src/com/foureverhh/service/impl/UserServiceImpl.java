package com.foureverhh.service.impl;

import com.foureverhh.mapper.UserMapper;
import com.foureverhh.pojo.User;
import com.foureverhh.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapperImpl;
    @Override
    public User login(User user) {
        return userMapperImpl.selByUser(user);
    }
}
