package com.foureverhh.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DemoInterceptor1 implements HandlerInterceptor {
    private int count;
    //进入controller之前执行
    //如果返回值为false，阻止进入controller
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("1->preHandle called before controller, handler");
        return true;
    }

    //controller执行完成，进入到jsp之前执行
    //可以获取到model和view的值
    //日志记录，敏感词语过滤
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("1->postHandle called before target jsp is called");
    }

    //（也是controller执行完成）并且jsp执行完成后执行
    //记录执行过程中出现的异常
    //可以把异常记录到日志中
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("1->afterCompletion called after target jsp is called");
    }
}
