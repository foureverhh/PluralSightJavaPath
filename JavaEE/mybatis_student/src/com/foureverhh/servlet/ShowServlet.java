package com.foureverhh.servlet;

import com.foureverhh.pojo.PageInfo;
import com.foureverhh.service.StudentService;
import com.foureverhh.service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/show")
public class ShowServlet extends HttpServlet {
    StudentService studentService = new StudentServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sName = req.getParameter("sName");
        String tName = req.getParameter("tName");
        String pageSize = req.getParameter("pageSize");
        String pageNumber = req.getParameter("pageNumber");
        System.out.println("servlet pageSize -> " + pageSize + ",pageNumber ->" + pageNumber);
        PageInfo pageInfo = studentService.showPage(sName,tName,pageSize,pageNumber);
        req.setAttribute("pageInfo",pageInfo);
        req.getRequestDispatcher("/index.jsp").forward(req,resp);
    }
}
