package com.bjsxt.dao.impl;

import com.bjsxt.dao.FlowerDao;
import com.bjsxt.pojo.Flower;

import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.transaction.Transactional;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/*
 * 数据访问层要有异常处理
 * */
public class FlowerDaoImpl implements FlowerDao {
    EntityManagerFactory factory = Persistence.createEntityManagerFactory("Flower");
    EntityManager manager = factory.createEntityManager();


    @Override
    public List<Flower> selectAll() {
        List<Flower> flowers = null;
        //transaction.begin();
        flowers = manager.createQuery("SELECT f FROM Flower f",Flower.class).getResultList();
        System.out.println(flowers.toString());
        return flowers;
    }

    @Transactional
    @Override
    public int insertFlower(Flower flower) {
        int result=-1;
        manager.getTransaction().begin();
        result= manager.createNativeQuery("INSERT INTO FLOWER VALUES (default,?,?,?)")
                .setParameter(1,flower.getName())
                .setParameter(2,flower.getPrice())
                .setParameter(3,flower.getProduction())
                .executeUpdate();
        manager.getTransaction().commit();
        System.out.println(result);
        return result;
    }
}
