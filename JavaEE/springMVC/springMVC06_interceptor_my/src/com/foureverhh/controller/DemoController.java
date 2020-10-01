package com.foureverhh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DemoController {
    @RequestMapping("/demo")
    public String demo(Model model){
        System.out.println("this is demo controller");
        model.addAttribute("model","我的祖国");
        //int a = 5/0;
        return "/index.jsp";
    }
}
