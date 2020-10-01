package com.bjsxt.dao;

import com.bjsxt.pojo.Flower;

import java.util.List;

public interface FlowerDao {
    List<Flower> selectAll();
    int insertFlower(Flower flower);
}
