package com.bjsxt.servlet;

import com.bjsxt.pojo.Flower;
import com.bjsxt.service.FlowerService;
import com.bjsxt.service.impl.FlowerServiceImpl;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/insert")
public class InsertServlet extends HttpServlet {
    private FlowerService service = new FlowerServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        double price = Double.parseDouble(req.getParameter("price"));
        String production = req.getParameter("production");
        Flower flower = new Flower(name,price,production);
        int result =  service.insertFlower(flower);
        if(result > 0){
            req.getSession().setAttribute("insert","done");
            //必须使用重定向，防止表单重复提交
            resp.sendRedirect("/mybatis_war_exploded/show");
        }else {
            resp.sendRedirect("/mybatis_war_exploded/add.jsp");
        }
    }
}
