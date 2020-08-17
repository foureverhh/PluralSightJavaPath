package com.foureverhh.gitlab.gitlabdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/demo")
public class DemoController {
    @RequestMapping("/hello")
    public String showDemo(){
        return "index";
    }
}
