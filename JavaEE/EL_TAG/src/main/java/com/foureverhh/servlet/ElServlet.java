package com.foureverhh.servlet;

import com.foureverhh.pojo.Address;
import com.foureverhh.pojo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/showInfo")
public class ElServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        req.getParameter("name");
        req.getParameter("pwd");

        //对象类型
        req.setAttribute("str","天气真好");
        User u = new User(1,"柳岩","电影",new Address("河南","商丘","虞城县"));
        req.setAttribute("user",u);

        //结合类型
            //List集合
                //存储普通字符
                List<String> list = new ArrayList<>();
                list.add("梁朝伟");
                list.add("关晓彤");
                list.add("刘诗诗");
                req.setAttribute("list",list);
                //存储对象
                User u2 = new User(2,"古力娜扎","拍电影",new Address("新疆","乌鲁木齐","乌鲁木齐"));
                List<User> list2 = new ArrayList<>();
                list2.add(u2);
                req.setAttribute("list2",list2);
            //Map集合
                //存储普通字符
                Map<String,String> map = new HashMap<>();
                map.put("a","北京");
                map.put("b","上海");
                map.put("c","广州");
                map.put("d","深圳");
                req.setAttribute("map",map);
                //存储对象
                Map<String,User> map2 = new HashMap<>();
                map2.put("a1",new User(3,"古力娜扎","拍电影",new Address("新疆","北疆","哈密")));
                req.setAttribute("map2",map2);
            //空值判断
                req.setAttribute("s","");
                req.setAttribute("s1",new User());
                req.setAttribute("s2",new ArrayList<>());
                req.setAttribute("s3",new HashMap<>());

        req.getRequestDispatcher("/el.jsp").forward(req,resp);
    }
}
