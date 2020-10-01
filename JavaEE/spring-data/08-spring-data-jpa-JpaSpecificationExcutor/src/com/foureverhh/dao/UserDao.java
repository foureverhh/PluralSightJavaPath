package com.foureverhh.dao;

import com.foureverhh.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;


import java.util.List;

/*
* JpaRepository接口详解
*
* */
public interface UserDao extends JpaRepository<User,Integer> {
    @Query("from User u where u.age > :queryAge")
    List<User> findAgeGreaterThan(@Param("queryAge") Integer age);
}
