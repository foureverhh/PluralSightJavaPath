package com.foureverhh.thymeleafurl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DemoController {
    @RequestMapping("/{page}")
    public String showInfo(@PathVariable String page,Integer id,String name){
        System.out.println("id= "+ id + ", name= " + name);
        return page;
    }
}
