package com.haha.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FateTellerController {
    @RequestMapping("/hello")
    public String sayHello(){
        System.out.println("I am hello!");
        return "hello";
    }
}
