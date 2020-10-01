package com.bjsxt.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/xml")
public class XMLServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/xml;charset=utf-8");
        resp.getWriter().write("<user>"+
                                    "<id>1</id>" +
                                    "<name>name</name>"+
                                    "<price>11.0</price>" +
                                    "<loc>location</loc>" +
                                    "<description>description</description>" +
                                 "</user>");
    }
}
