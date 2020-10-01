package com.fourever.springboot15exception.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DemoController {
    @RequestMapping("/show")
    public String showInfo(){

            String str = null;
            System.out.println(str.length());

        return "index";
    }

    @RequestMapping("/show2")
    public String showInfo2(){
        int i = 10/0;
        return "index";
    }

    /*
    * handle java.lang.ArithmeticException
    * 该方法返回一个ModelAndView，目的是可以让我们封装异常信息及指定显示的视图
    * 参数Exception e是必须的，从而将exception注入到springMVC
    * */
    @ExceptionHandler(value = {java.lang.ArithmeticException.class})
    public ModelAndView arithmeticExceptionHandler(Exception e){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("error",e.toString());
        modelAndView.setViewName("errorArithmetic");
        return modelAndView;
    }

    @ExceptionHandler(value={java.lang.NullPointerException.class})
    public ModelAndView nullExceptionError(Exception e){
        ModelAndView mv = new ModelAndView();
        mv.addObject("error",e.toString());
        mv.setViewName("nullPointerError");
        return mv;
    }

}
