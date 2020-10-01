package com.foureverhh.service.impl;

import com.foureverhh.mapper.mybatis_provider.UserMapper;
import com.foureverhh.pojo.mybatis_provide.User;
import com.foureverhh.service.UserService;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

 /*   public UserMapper getUserMapper() {
        return userMapper;
    }

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }*/

    @Override
    public int insertUser(User user) {
        return userMapper.insertUser(user);
    }

    @Override
    public int insertBatchUser(Map<String, Object> map) {
        return userMapper.insertBatchUser(map);
    }
}
