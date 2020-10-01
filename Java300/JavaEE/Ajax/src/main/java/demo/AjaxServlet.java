package demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@WebServlet("/ajax")
public class AjaxServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置请求编码格式
        req.setCharacterEncoding("UTF-8");
        //设置响应编码格式
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        //获取请求
        Enumeration<?> params = req.getParameterNames();
        Map<String,String> paramsMap = new HashMap<>();
        while (params.hasMoreElements()){
            String key = (String) params.nextElement();
            String value = req.getParameter(key);
            resp.getWriter().write("In getParameterNames\n");
            resp.getWriter().append("We have ").append(key).append(" with value as ").append(value).append("\n");
            System.out.println("We have " + key + " with value as " + value + "\n");
            paramsMap.put(key,value);
        }
        //处理请求
        //响应处理结果
        for (Map.Entry<String, String> entry : paramsMap.entrySet()) {
            resp.getWriter().append("In Map.Entry\n");
            resp.getWriter().append("We have ").append(entry.getKey()).append(" with value as ").append(entry.getValue()).append("\n");
            System.out.println("We have " + entry.getKey() + " with value as " + entry.getValue() + "\n");

        }
        resp.getWriter().write("今天的雾霾好纯！");
    }
}
