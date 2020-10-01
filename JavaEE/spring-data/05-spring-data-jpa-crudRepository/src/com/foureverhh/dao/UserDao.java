package com.foureverhh.dao;

import com.foureverhh.pojo.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

/*
* Repository接口详解
*
* */
public interface UserDao extends Repository<User,Integer> {
    //方法命名规则
    List<User> findByNameIs(String name);
    /*
    * 根据用户姓名做Like处理
    * */
    List<User> findByNameLike(String name);
    List<User>  findByNameLikeAndAgeGreaterThanEqual(String name, int age);

    //使用@Query注解查询
    @Query("from User where name = ?1")
    List<User> queryUserByNameJPQL(String name);

    @Query("from User where name like ?1")
    List<User> queryUserByLikeNameJPQL(String queryName);

    @Query("from User where name like ?1 and age >= ?2")
    List<User> queryUserByLikeNameAndAgeJPQL(String queryName,int age);


    /*sql*/
    @Query(value = "select * from t_user where user_name = ?1",nativeQuery = true)
    List<User> queryUserByNameSQL(String name);

    @Query(value = "select * from t_user where user_name like ?1 and user_age >= ?2",nativeQuery = true)
    List<User> queryUserByLikeNameSQL(String queryName);

    @Query(value = "select * from t_user where user_name like ?1",nativeQuery = true)
    List<User> queryUserByLikeNameAndAgeSQL(String queryName,Integer age);

    @Query("update User u set u.age = ?1 where u.id = ?2")
    @Modifying
    @Transactional
    @Rollback(value = false)
    void updateUserAgeById(Integer age,Integer id);

}
