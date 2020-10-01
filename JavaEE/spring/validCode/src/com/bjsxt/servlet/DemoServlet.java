package com.bjsxt.servlet;


import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
@WebServlet("/demo")
public class DemoServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //字符流,发送各种html，css，js等字节类的文件
        //PrintWriter out = resp.getWriter();
        //字节流，发送各种img，audio，video类的文件
        ServletOutputStream os = resp.getOutputStream();
        //getRealpath可以获得web项目下根目录的路径
        InputStream is = new FileInputStream(new File(getServletContext().getRealPath("images"),"a.png"));
        int index = -1;
        while ((index = is.read())!=-1){
            os.write(index);
        }
    }
}
