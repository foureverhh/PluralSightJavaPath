package com.foureverhh.service;

import com.foureverhh.pojo.mybatis_provide.User;

import java.util.List;
import java.util.Map;

public interface UserService {
    int insertUser(User user);
    int insertBatchUser(Map<String, Object> map);
}
