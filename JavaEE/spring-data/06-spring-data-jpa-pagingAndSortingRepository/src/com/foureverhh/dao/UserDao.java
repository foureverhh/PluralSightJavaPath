package com.foureverhh.dao;

import com.foureverhh.pojo.User;
import org.springframework.data.repository.CrudRepository;


import java.util.List;

/*
* Repository接口详解
*
* */
public interface UserDao extends CrudRepository<User,Integer> {

}
