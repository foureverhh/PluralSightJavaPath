package com.bjsxt.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.*;
import java.util.List;

@WebServlet("/code")
public class ValidCodeServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //创建一张图片底板，单位为像素
        BufferedImage image = new BufferedImage(100,50,BufferedImage.TYPE_INT_RGB);
        //创建附在底板上的透明玻璃
        Graphics2D graphics = image.createGraphics();
        //往玻璃上画之前需要设置画笔
        graphics.setColor(Color.white);
        //填充矩形区域,将底板设置为白色
        //graphics.fillRect(0,0,200,100);
        graphics.fillRect(0,0,100,50);
        //设置数字颜色为红色
        graphics.setColor(Color.red);
        //设置数字字体格式
        graphics.setFont(new Font("宋体",Font.BOLD|Font.ITALIC,30));
        Color[] colors = new Color[]{Color.cyan,Color.red,Color.GRAY,Color.BLUE};
        List<String> validCode = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 4 ; i++) {
            validCode.add(random.nextInt(10)+"");
        }
        for (int i = 0; i < 4 ; i++) {
            graphics.setColor(colors[random.nextInt(colors.length)]);
            graphics.drawString(validCode.get(i),10+i*20,25+(random.nextInt(11)-2));
        }
        //画横线
        graphics.setColor(colors[random.nextInt(colors.length)]);
        graphics.drawLine(0,25,100,25);

        //画两条随机线
        for (int i = 0; i <2 ; i++) {
            graphics.setColor(colors[random.nextInt(colors.length)]);
            graphics.drawLine(random.nextInt(101),random.nextInt(26),random.nextInt(50),random.nextInt(20));
        }

        ServletOutputStream os = resp.getOutputStream();
        //工具类,将图片按照PNG格式，写入到servletOutputStream
        ImageIO.write(image,"PNG",os);

        req.getSession().setAttribute("validCode",validCode.get(0)+validCode.get(1)+validCode.get(2)+validCode.get(3));
        resp.sendRedirect("index.jsp");
    }
}
