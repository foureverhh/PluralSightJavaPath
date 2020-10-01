package com.foureverhh.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
     /*   //拦截器需要放行第一次的登录请求
        if(request.getRequestURI().equals("/auth/login")){
            return true;
        }else {*/
            if(request.getSession().getAttribute("user")!=null){
                //表示用户已经登录
                return true;
            }
            response.sendRedirect("/auth/login.jsp");
            return false;
       // }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
