package com.bjsxt.service.serviceImpl;

import com.bjsxt.dao.UserDao;
import com.bjsxt.dao.daoImpl.UserDaoImpl;
import com.bjsxt.pojo.User;
import com.bjsxt.service.UserService;

public class UserServiceImpl implements UserService {
    UserDao userDao = new UserDaoImpl();
    @Override
    public User getUserInfoService(String name) {
       return userDao.getUserInfoService(name);
    }
}
