package com.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class DemoController {
    @RequestMapping("/demo")
    public String demo(HttpServletRequest request){
        request.setAttribute("req","Req的值");
        request.getSession().setAttribute("session1","session1的值");
        request.getSession().setAttribute("session2","session2的值");
        request.getServletContext().setAttribute("application","application的值");
        return "main";
    }

    @RequestMapping("/demo1")
    public String demo2(HttpSession session){
        Object object = session.getAttribute("session");
        System.out.println(object);
        return "index";
    }

    @RequestMapping("/demo2")
    public String demo2(@SessionAttribute String session1,@SessionAttribute String session2){
        System.out.println(session2 + ", " + session1);
        return "index";
    }

    @RequestMapping("/collection")
    public String collDemo(Map<String , Object> map){
        map.put("map","map的值"); //实际是通过request作用域
        return "index";
    }

    @RequestMapping("/modelDemo")
    public String collDemo(Model model){
        model.addAttribute("model","model的值"); //实际是通过request作用域
        return "index";
    }

    @RequestMapping("/mavDemo")
    public ModelAndView modelAndViewDemo(){
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("mav","mav的值");//实际是通过request作用域
        return mav;
    }
}
