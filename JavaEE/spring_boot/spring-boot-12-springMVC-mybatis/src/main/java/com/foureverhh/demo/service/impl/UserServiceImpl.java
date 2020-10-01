package com.foureverhh.demo.service.impl;

import com.foureverhh.demo.mapper.UserMapper;
import com.foureverhh.demo.pojo.User;
import com.foureverhh.demo.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;
    @Override
    public int insertUser(User user) {
        return userMapper.addUser(user);
    }

    @Override
    public List<User> showAll() {
        return userMapper.selectAll();
    }

    @Override
    public User findUserById(Integer id) {
        return userMapper.selectUserById(id);
    }

    @Override
    public int updateUser(User user) {
        return userMapper.updateUser(user);
    }

    @Override
    public int deleteUserById(Integer id) {
        return userMapper.deleteUserById(id);
    }

}
