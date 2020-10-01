package com.example.springboot20springloader.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
    @RequestMapping("/show")
    public String showPage(){
        System.out.println("hello ....us");
        return "index";
    }
}
