package com.foureverhh.dao;

import com.foureverhh.pojo.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;


import java.util.List;

/*
* Repository接口详解
*
* */
public interface UserDao extends PagingAndSortingRepository<User,Integer> {

}
