package com.foureverhh.service;

import com.foureverhh.pojo.User;

import java.util.Map;

public interface UserService {
    User login(User user);
    //User myLogin(User user);
    Map<String,Object> loginMap(User user);
}
