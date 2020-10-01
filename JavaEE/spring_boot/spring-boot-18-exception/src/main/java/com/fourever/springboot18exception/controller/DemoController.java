package com.fourever.springboot17exception.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DemoController {
    @RequestMapping("/show")
    public String showInfo(){

            String str = null;
            System.out.println(str.length());

        return "index";
    }

    @RequestMapping("/show2")
    public String showInfo2(){
        int i = 10/0;
        return "index";
    }


}
