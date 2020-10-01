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
* 一对一测试
*
* */
public interface UserDao extends JpaRepository<User,Integer>, JpaSpecificationExecutor<User>{

}
