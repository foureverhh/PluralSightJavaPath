package com.foureverhh.controller;

import com.foureverhh.pojo.User;
import com.foureverhh.service.ElementService;
import com.foureverhh.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class UserController {
    @Resource
    private UserService userServiceImpl;

    @RequestMapping("/login")
    public String login(User user, HttpSession session){
        //User currentUser = userServiceImpl.login(user);
        Map<String,Object> map = userServiceImpl.loginMap(user);
        //User currentUser = userServiceImpl.myLogin(user);
        if(map.get("user") != null) {
            session.setAttribute("user",map.get("user"));
            session.setAttribute("allUrl",map.get("allUrl"));
            System.out.println("Urls -> " + ((User)map.get("user")).getUrls().toString());
            return "redirect:/main.jsp";
        }else {
            return "redirect:/index.jsp";
        }
    }

    @RequestMapping("demo")
    public String demo(){
        System.out.println("执行demo");
        return "main";
    }
}
