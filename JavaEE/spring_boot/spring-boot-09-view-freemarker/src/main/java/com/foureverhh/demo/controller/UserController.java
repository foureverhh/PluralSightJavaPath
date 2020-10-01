package com.foureverhh.demo.controller;

import com.foureverhh.demo.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {
    @RequestMapping("/showUser")
    public String showUser(HttpServletRequest req){
        List<User> users = new ArrayList<>();
        users.add(new User(1,"张三",20));
        users.add(new User(2,"李四",22));
        users.add(new User(3,"王五",24));
        req.setAttribute("users",users);
        //跳转视图
        return "userList";
    }
}
