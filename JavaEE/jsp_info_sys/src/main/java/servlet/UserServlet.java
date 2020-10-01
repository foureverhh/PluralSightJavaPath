package servlet;

import pojo.User;
import service.UserService;
import service.serviceImpl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;

@WebServlet("/user/demo")
public class UserServlet extends HttpServlet {
    Logger logger = Logger.getLogger(UserServlet.class);
    UserService userService = new UserServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws  IOException {
        //设置请求编码格式
        req.setCharacterEncoding("utf-8");
        //设置响应编码格式
        resp.setContentType("text/html;charset=utf-8");
        //获取请求信息
            //input type="hidden" name="oper" value="..." 传参
            String oper = req.getParameter("oper");
            switch (oper){
                //调用注册处理方法
                case "reg":
                    registerUser(req,resp);
                    break;
                //调用登录处理方法
                case "login":
                    checkUserLogin(req,resp);
                    break;
                //user/resetPwd.jsp 重置密码
                case "resetPwd":
                    resetUserPwd(req,resp);
                    break;
                case "logout":
                    userLogout(req,resp);
                    break;
                case "showAll":
                    showAll(req,resp);
                    break;
                default:
                    logger.debug("No suitable oper prarameter" + oper);

            }
        //处理请求信息

        //响应处理结果

            //直接响应

            //请求转发

            //重定向

    }

    private void registerUser(HttpServletRequest req, HttpServletResponse resp) {
        String uname = req.getParameter("uname");
        String pwd = req.getParameter("pwd");
        String sex = req.getParameter("sex");
        int age = Integer.parseInt(req.getParameter("age"));
        String birth = req.getParameter("birth");
        User user = new User(uname,pwd,sex,age,birth);
        System.out.println(user);

        //调用业务层
        int result = userService.registerUser(user);
        logger.debug("register result: " + result);
        if(result > 0){
            HttpSession session = req.getSession();
            //session.setAttribute("succeedRegistered","true");
            session.setAttribute("flag",2);
            try {
                //回到login.jsp
                resp.sendRedirect("/info/login.jsp");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


    private void showAll(HttpServletRequest req, HttpServletResponse resp) {
        List<User> users = userService.showAll(req,resp);
        if(users.size()!=0){
            //将查询的用户数据存储到request对象
            req.setAttribute("allUsers",users);
            try {
                req.getRequestDispatcher("/user/showUser.jsp").forward(req,resp);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void resetUserPwd(HttpServletRequest req, HttpServletResponse resp) {
        String newPwd = req.getParameter("newPwd");
        HttpSession session = req.getSession();
        User user = (User)session.getAttribute("user");
        int id = user.getUid();
        int updateResult = userService.resetPwdInfo(id,newPwd);
        logger.debug("update reslut: " + updateResult);
        if(updateResult > 0){
            try {
                //获取session
                HttpSession hs = req.getSession();
                //hs.setAttribute("pwdReset","true");
                hs.setAttribute("flag",1);
                //重定向到登录界面
                resp.sendRedirect("/info/login.jsp");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void userLogout(HttpServletRequest req, HttpServletResponse resp) {
        //获取session
        HttpSession session = req.getSession();
        //销毁session
        session.invalidate();
        //返回login
        try {
            resp.sendRedirect("/info/login.jsp");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //处理登录
    private void checkUserLogin(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //处理请求信息
        String uname = req.getParameter("uname");
        String pwd = req.getParameter("pwd");
        logger.debug("uname:" + uname + " , pwd:" + pwd);

        //响应处理结果
            User user = userService.checkUserLoginService(uname,pwd);
            logger.info("user is: " +  user);
        if(user != null){
            //获取session
            HttpSession hs = req.getSession();
            //将用户数据存储到session中
            hs.setAttribute("user",user);
            //绝对路径 /代表项目根目录 config里面的URL,即项目文件夹
            //resp.sendRedirect("/info/main/main.jsp");
            resp.sendRedirect("/info/main/main.jsp");
            //相对路径别名如果是目录，只能相对于当前文件夹的上级, 从 user/info 转到 user/main/main.jsp
            //resp.sendRedirect("main/main.jsp");
        }else {
            //请求准发
            try {
                req.setAttribute("flag",0);
                req.getRequestDispatcher("/login.jsp").forward(req,resp);
            } catch (ServletException e) {
                e.printStackTrace();
            }
        }
    }

}
