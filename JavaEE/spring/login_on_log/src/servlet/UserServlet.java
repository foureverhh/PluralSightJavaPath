package servlet;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import pojo.User;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/login")
public class UserServlet extends HttpServlet {
    UserService userService;
    @Override
    public void init() throws ServletException {
        super.init();
        WebApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
        userService = context.getBean("userService",service.impl.UserServiceImpl.class);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        User requiredUser = new User();
        requiredUser.setUsername(req.getParameter("username"));
        requiredUser.setPassword(req.getParameter("password"));
        System.out.println(requiredUser);
        User user = userService.login(requiredUser);
        System.out.println(user);
        List<User> all = userService.selAll();
        HttpSession session = req.getSession();
        session.setAttribute("all",all);
        if(user!=null){
            resp.sendRedirect("/login/main.jsp");
        }else {
            resp.sendRedirect("/login/index.jsp");
        }
    }
}
