package com.bjsxt.service.impl;

import com.bjsxt.dao.FlowerDao;
import com.bjsxt.dao.impl.FlowerDaoImpl;
import com.bjsxt.pojo.Flower;
import com.bjsxt.service.FlowerService;

import javax.naming.NamingException;
import java.util.List;

public class FlowerServiceImpl implements FlowerService {
    private FlowerDao flowerDao = new FlowerDaoImpl();

    @Override
    public List<Flower> show() {
        List<Flower> flowers = flowerDao.selectAll();
        System.out.println("In show(): " + flowers.toString());
        return flowers;
    }

    @Override
    public int insertFlower(Flower flower) {
        return flowerDao.insertFlower(flower);
    }


}
