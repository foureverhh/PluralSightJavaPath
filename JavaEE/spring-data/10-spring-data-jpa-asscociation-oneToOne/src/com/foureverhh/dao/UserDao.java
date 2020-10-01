package com.foureverhh.dao;

import com.foureverhh.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;


import java.util.List;

/*
* JpaSpecificationExecutor<>接口详解
*   JpaSpecificationExecutor<>不能单独使用，需要配合JPA其他接口使用
* */
public interface UserDao extends JpaRepository<User,Integer>, JpaSpecificationExecutor<User> ,UserRepository{

}
