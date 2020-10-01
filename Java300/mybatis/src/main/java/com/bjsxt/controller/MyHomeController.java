package com.bjsxt.controller;

import com.bjsxt.pojo.Flower;
import com.bjsxt.service.FlowerService;
import com.bjsxt.service.impl.FlowerServiceImpl;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.naming.NamingException;
import java.io.Serializable;
import java.util.List;

@Named("myHomeController")
@SessionScoped
public class MyHomeController implements Serializable {
    private static final Long serialVersionUID = 1L;
    private String greeting;
    private List<Flower> flowers;

    public MyHomeController() {
    }

    public String getGreeting() {
        return greeting;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }

    @PostConstruct
    public void init() {
        greeting = "Hello!";
        FlowerService flowerService = new FlowerServiceImpl();
        flowers = flowerService.show();
        System.out.println("inti() flowers: " + flowers);
    }

    public List<Flower> getFlowers() {
        return flowers;
    }

    public void setFlowers(List<Flower> flowers) {
        this.flowers = flowers;
    }
}
