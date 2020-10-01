package ajaxData.servlet;

import ajaxData.model.User;
import ajaxData.service.UserService;
import ajaxData.serviceImpl.UserServiceImpl;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/user")
public class UserServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        String name = req.getParameter("name");
        System.out.println("用户请求为： " + name);
        //处理请求信息
            //获取业务层对象
        UserService service = new UserServiceImpl();
        User user = service.getUserInfoService(name);
        System.out.println("User service: user -> " + user);
        if(user != null){
           /*
           //1.通过操作node实现
           String newRow =
                                    "<td>"+
                                        user.getUid() +
                                    "</td>"+
                                    "<td>"+
                                        user.getUname() +
                                    "</td>"+
                                    "<td>"+
                                        user.getPrice() +
                                    "</td>"+
                                        user.getLoc() +
                                    "<td>"+
                                        user.getDesc() +
                                    "</td>"
                            ;
            resp.getWriter().write(newRow);
            */
            /*
            //通过eval将来实现将java对象user封装为js对象user
            String response = //"let obj = {};" + //只需要在jsp中定义好obj{}
                                "obj.name= \'" + user.getUname() + "\';" +
                                "obj.uid=" + user.getUid() + ";"  +
                                "obj.price=" + user.getPrice() + ";"  +
                                "obj.description=" + user.getDesc() + ";"  +
                                "obj.loc=\'" + user.getLoc() + "\';";
            //将一个js object 作为response发回去
            resp.getWriter().write(response);
            */
            /* //通过json声明格式以及eval来将java对象user封装为js对象user
            String response = "{name:\'"+user.getUname() +"\',"+"price:" + user.getPrice() + "}";
            //将一个js object 作为response发回去
            resp.getWriter().write(response);*/

            //通过new Gson().toJson(obj)
            resp.getWriter().write(new Gson().toJson(user));

        } else {
            resp.getWriter().write("Nothing found!");
        }
    }
}
