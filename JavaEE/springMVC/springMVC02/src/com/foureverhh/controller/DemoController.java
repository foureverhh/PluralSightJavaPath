package com.foureverhh.controller;

import com.foureverhh.pojo.Demo;
import com.foureverhh.pojo.People;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class DemoController {
    @RequestMapping("demo")
    public String demo(People people, String name, int age, Model model, HttpServletRequest req){
        System.out.println("I get " + people + ", " +name + ", "+age);
        //model.addAttribute("peo",people);
        req.setAttribute("demo123","测试");
        return "/main.jsp";
    }

    @RequestMapping("page")
    public String page(@RequestParam(defaultValue = "2") int pageSize,@RequestParam(defaultValue = "1") int pageNumber){
        System.out.println("PageSize" + pageSize + ", " + "PageNumber" + pageNumber);
        return "/main.jsp";
    }

    @RequestMapping("demo2")
    public String demo2(@RequestParam(required = true) String name){
        System.out.println("name是SQL的查询条件，必须要传递name的参数"+name);
        return "/main.jsp";
    }
    //required与defaultValue不要一起用
    @RequestMapping("demo3")
    public String demo3(@RequestParam(required = true,defaultValue = "测试")String name){
        System.out.println("name");
        return "/main.jsp";
    }

    @RequestMapping("demo05/test")
    public String demo05(String name, int age, @RequestParam(value = "hover")List<String> hover){
        System.out.println(name + ", " + age + ", " + hover);
        return "main";
    }

    @RequestMapping("demo06")
    public String demo06(Demo demo, String name, int age, @RequestParam(value = "hover")List<String> hover){
        System.out.println(name + ", " + age + ", " + hover);
        System.out.println(demo);
        return "main";
    }

    @RequestMapping("demo07/{id}/{name}")
    public String demo07(@PathVariable String name,@PathVariable int id){
        System.out.println(name + ", " +id);
        return "main";
    }

    @RequestMapping("demo08/test") //redirect会抵消internalResourceViewResolver的prefix和suffix，从而访问其他的servlet
    public String demo08(){
        System.out.println("重定向");
        //return "redirect:/mvc/main.jsp";
        return "redirect:/main.jsp";//重定向到main.jsp
    }

    @RequestMapping("demo09") //forward会抵消internalResourceViewResolver的prefix和suffix，从而访问其他的servlet
    public String demo09(){
        System.out.println("转发");
        return "forward:demo10";
    }

    @RequestMapping("demo10")
    public String demo10(){
        System.out.println("This is demo10");
        return "main";
    }

    @RequestMapping(value = "jsonDemo") //produces="text/html;charset=uft-8" 使用produces设置响应头
    @ResponseBody //表示返回的datatype为application/json
    public People jsonDemo(){
        People p =  new People();
        p.setAge(10);
        p.setName("张三");
        return p;
    }
}
