package com.bjsxt.service;

import com.bjsxt.pojo.Flower;

import java.util.List;

public interface FlowerService {
    List<Flower> show();
    int insertFlower(Flower flower);
}
