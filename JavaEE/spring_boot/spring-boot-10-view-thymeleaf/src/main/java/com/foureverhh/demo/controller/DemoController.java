package com.foureverhh.demo.controller;

import com.foureverhh.demo.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Controller
public class DemoController {
    @RequestMapping("/strings")
    public String showStrings(Model model){
        model.addAttribute("msg","Thymeleaf 第一个案例");
        return "index";
    }

    @RequestMapping("/dates")
    public String showDates(Model model){
        model.addAttribute("dates","datesDemo");
        model.addAttribute("key",new Date());
        return "dates";
    }

    @RequestMapping("/show")
    public String showInfo(Model model){
        model.addAttribute("sex","女");
        //model.addAttribute("id","2");
        model.addAttribute("id",2);
        return "demoIf";
    }

    @RequestMapping("/iterateList")
    public String iterateListDemo(Model model){
        List<User> users = new ArrayList<>();
        users.add(new User(1,"张三",20));
        users.add(new User(2,"李四",22));
        users.add(new User(3,"王五",24));
        model.addAttribute("usersList",users);
        return "demoIterateList";
    }

    @RequestMapping("/iterateMap")
    public String iterateMapDemo(Model model){
        Map<String,User> users = new HashMap<>();
        users.put("u1",new User(1,"张三",20));
        users.put("u2",new User(2,"李四",22));
        users.put("u3",new User(3,"王五",24));
        model.addAttribute("usersMap",users);
        return "demoIterateMap";
    }

    @RequestMapping("/field")
    public String filedDemo(HttpServletRequest req, Model model){
        req.setAttribute("req","HttpServletRequest");
        req.getSession().setAttribute("session","HttpSession");
        req.getServletContext().setAttribute("app","Application");
        return "demoField";
    }
}
