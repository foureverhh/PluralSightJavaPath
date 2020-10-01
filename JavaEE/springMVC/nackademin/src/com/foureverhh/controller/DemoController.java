package com.foureverhh.controller;

import com.foureverhh.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class DemoController {
    @RequestMapping("/{page}")
    public String demo(@PathVariable String page){
        System.out.println("path variable works");
        return page;
    }

    @RequestMapping("/login")
    public String login(User user, HttpSession session){
        if(user.getUsername().equals("admin")&&user.getPassword().equals("123")){
           session.setAttribute("user",user);
           return "main";
        }else {
            System.out.println("login matches");
            return "redirect:/login.jsp";
        }
    }
}
