package com.foureverhh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DemoController {
    /*
    * 不管requestMapping 是写/demo还是/demo.do
    * http://localhost:8080/demo09/demo.do都会访问dispatch-servlet
    * 但是URL必须为http://localhost:8080/demo09/demo.do
    * http://localhost:8080/demo09/demo会导致错误
    * */
    @RequestMapping("/demo")
    public String demo(){
        System.out.println("demo");
        return "redirect:/login.jsp";
    }
}
