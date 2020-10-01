package com.bjsxt.servlet;

import com.bjsxt.pojo.User;
import com.bjsxt.service.UserService;
import com.bjsxt.service.impl.UserServiceImpl;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private UserService userService;

    @Override
    public void init() throws ServletException {
        userService = WebApplicationContextUtils
                     .getRequiredWebApplicationContext(getServletContext())
                     .getBean("userService", UserServiceImpl.class);
        super.init();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String code = req.getParameter("code");
        HttpSession session = req.getSession();
        String validCode = (String)session.getAttribute("validCode");
        if(code.equals(validCode)){
            String username = req.getParameter("username");
            String password = req.getParameter("password");
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            User queryUser = userService.login(user);
            if(queryUser != null){
                req.getSession().setAttribute("username",username);
                resp.sendRedirect("/validCode/main.jsp");
            }else {
                req.setAttribute("error","密码与用户名不匹配");
                req.getRequestDispatcher("index.jsp").forward(req,resp);
            }
        }else {
            req.setAttribute("error","验证码不正确");
            req.getRequestDispatcher("index.jsp").forward(req,resp);
        }


    }
}
