package com.foureverhh.controller;

import com.foureverhh.pojo.User;
import com.foureverhh.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
public class UserController {
    @Resource
    private UserService userServiceImpl;

    @RequestMapping("/login")
    public String login(User user, HttpSession session){
        User currentUser = userServiceImpl.login(user);
        if(currentUser != null) {
            session.setAttribute("user",currentUser);
            return "redirect:/main.jsp";
        }else {
            return "redirect:/index.jsp";
        }
    }

}
