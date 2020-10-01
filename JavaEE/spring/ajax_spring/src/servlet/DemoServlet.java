package servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import pojo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/demo")
public class DemoServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        User user1 = new User();
        user1.setId(2);
        user1.setPassword("123");
        user1.setName("张三");
        User user2 = new User();
        user2.setId(3);
        user2.setName("李四");
        user2.setPassword("456");
        List<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        ObjectMapper mapper = new ObjectMapper();
        String result = mapper.writeValueAsString(users);
/*        String name = req.getParameter("name");
        System.out.println("request info: " + name);*/
        resp.setContentType("application/json;charset=utf-8");
        PrintWriter out  = resp.getWriter();
        out.println(result);
        out.flush();
        out.close();
    }
}
