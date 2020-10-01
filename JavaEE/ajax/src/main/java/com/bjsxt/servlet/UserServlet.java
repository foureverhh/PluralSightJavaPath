package com.bjsxt.servlet;

import com.bjsxt.pojo.User;
import com.bjsxt.service.UserService;
import com.bjsxt.service.serviceImpl.UserServiceImpl;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/user")
public class UserServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //编码请求格式和响应格式
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        //获取请求信息
        String name = req.getParameter("name");
        System.out.println("name to be searched is " + name);
        //处理请求信息
        UserService userService = new UserServiceImpl();
        User user = userService.getUserInfoService(name);
        System.out.println(user);
        Gson gson = new Gson();
        String userJson = gson.toJson(user);
        resp.getWriter().write(userJson);
    }
}
