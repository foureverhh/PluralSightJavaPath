package com.foureverhh.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class TestServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("str","测试监听器1");
        //req.setAttribute("str","测试监听器2");
        HttpSession hs = req.getSession();
        hs.setAttribute("str","mySession");
        hs.invalidate();
        ServletContext sc = this.getServletContext();
        sc.setAttribute("str","application 中添加了attribute");
        resp.getWriter().write("hello 监听器");
    }
}
