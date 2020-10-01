package com.foureverhh.servlet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


@WebServlet("/pool")
public class DemoServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //创键InitialContext实例，获取META/context.xml内容
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        try {
            Context ctx = new InitialContext();
            DataSource ds = (DataSource) ctx.lookup("java:comp/env/test");
            System.out.println(ds.getClass().getSimpleName());
            Connection conn = ds.getConnection();
            PreparedStatement ps = conn.prepareStatement("select * from flower");
            ResultSet rs = ps.executeQuery();
            PrintWriter out = resp.getWriter();
            out.write("<ul>");
            while (rs.next()){
                out.write("<li>");
                out.write(rs.getInt(1) + " , ");
                out.write(rs.getString(2) + " , ");
                out.write(rs.getDouble(3) + " , ");
                out.write(rs.getString(4));
                out.write("</li>");
            }
            out.write("</ul>");
            out.write("success done!");
            out.flush();
            out.close();

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
