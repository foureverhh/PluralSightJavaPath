package com.foureverhh.spring_boot_02_servlet.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*spring 整合 servlet*/
@WebServlet("/fistServlet")
//@WebServlet(name="/servlet",urlPatterns = "/first")
public class FirstServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=uft-8");
        resp.getWriter().print("<h1>我是servlet<h1>");
    }
}
